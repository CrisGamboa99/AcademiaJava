package com.proyectoFinal.mongodbBulkUpdate.rest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.bulk.BulkWriteResult;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.proyectoFinal.mongodbBulkUpdate.bo.EmpleadoBean;

@RestController
public class MongodbBulkUpdateController {

	@Value("${file.input}")
    private String fileInput;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/mongodbbulkupdate")
    public String directHomePage() {
        try {
            commitBulkUpdateToMongoDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Mongodb Bulk Update Processed";
    }

    private void commitBulkUpdateToMongoDB() {
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(fileInput));
        	CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        	CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(1).build();

            List<String[]> allData = csvReader.readAll();
            int count = 0;
            EmpleadoBean empleadoData = null;
            List<EmpleadoBean> empleadoInfoList = new ArrayList<>();

            for (String[] empleadoRow : allData) {
                String[] empleadoStringArry = new String[empleadoRow.length];
                empleadoData = new EmpleadoBean();
                count = 0;
                for (String empleadoInfo : empleadoRow) {
                	empleadoStringArry[count] = empleadoInfo;
                    count++;
                }
                empleadoData.setEmpId(empleadoStringArry[0]);
                empleadoData.setEmpNombre(empleadoStringArry[1]);
                empleadoData.setEmpDesc(empleadoStringArry[2]);
                empleadoData.setSalario(empleadoStringArry[3]);
                empleadoInfoList.add(empleadoData);
            }

            BulkOperations bulkOps = 
            		mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, EmpleadoBean.class);
            empleadoInfoList.stream().filter(empleado -> empleado != null).forEach(empleado -> {
                org.bson.Document dbDoc = new org.bson.Document().append("$set", empleado);
                mongoTemplate.getConverter().write(empleado, dbDoc);
                Query query = new Query().addCriteria(new Criteria("uuid").is(empleado.getEmpId()));
                Update update = Update.fromDocument(dbDoc, "");
                bulkOps.upsert(query, update);
            });

            BulkWriteResult result = bulkOps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
