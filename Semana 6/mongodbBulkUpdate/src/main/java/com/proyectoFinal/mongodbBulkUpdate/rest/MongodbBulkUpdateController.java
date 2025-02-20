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

// Se indica la clase como un controlador Rest
@RestController
public class MongodbBulkUpdateController {

	// Se inyectar el valor con la propiedad file.input de application.properties
	@Value("${file.input}")
    private String fileInput;

	// Se realiza la inyección de una instancia de MongoTemplate
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/mongodbbulkupdate") // El método se ejecuta cuando se hace una solicitud Get
    public String directHomePage() {
        try {
            commitBulkUpdateToMongoDB(); // Se llama al método
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Mongodb Bulk Update Processed"; // Devuelve un mensaje
    }

    private void commitBulkUpdateToMongoDB() {
        try {
        	BufferedReader reader = 
        			new BufferedReader(new FileReader(fileInput)); // Para leer el archivo 
        														// especificado por fileInput
        	
        	// CSVParser y CSVReader procesan el archivo csv
        	CSVParser parser = new CSVParserBuilder()
        				.withSeparator(',')
        				.build(); // Procesa el archivo csv con , como separador
        	CSVReader csvReader = new CSVReaderBuilder(reader)
        				.withCSVParser(parser)
        				.withSkipLines(1)
        				.build(); // Omite la primera línea del csv

            List<String[]> allData = csvReader.readAll(); // Se guarda el contenido del csv
            int count = 0;
            EmpleadoBean empleadoData = null;
            List<EmpleadoBean> empleadoInfoList = new ArrayList<>(); // Para guardar objetos de
            															// tipo EmpleadoBean

            // Se recorre cada fila del csv y asigna los valores a una instancia de EmpleadoBean
            for (String[] empleadoRow : allData) {
                String[] empleadoStringArry = new String[empleadoRow.length];
                empleadoData = new EmpleadoBean();
                count = 0;
                for (String empleadoInfo : empleadoRow) {
                	empleadoStringArry[count] = empleadoInfo;
                    count++;
                }
                
                // Para asignar los valores a los atributos de EmpleadoBean
                empleadoData.setEmpId(empleadoStringArry[0]);
                empleadoData.setEmpNombre(empleadoStringArry[1]);
                empleadoData.setEmpDesc(empleadoStringArry[2]);
                empleadoData.setSalario(empleadoStringArry[3]);
                empleadoInfoList.add(empleadoData);
            }

            // Se usa bulkOps en modo UNORDERED (las operaciones pueden ejecutarse en 
            // cualquier orden para mayor eficiencia)
            BulkOperations bulkOps = 
            		mongoTemplate.bulkOps(BulkOperations
            								.BulkMode
            								.UNORDERED, 
            								EmpleadoBean.class);
            
            // Se crea un stream con las operaciones a realizar
            empleadoInfoList.stream()
            				.filter(empleado -> empleado != null) 
            				.forEach(empleado -> { org.bson 
            							.Document dbDoc = new org.bson.Document()
            							.append("$set", empleado); // Se crea un documento 
            										// BSON (dbDoc) con los cambios a aplicar
            						mongoTemplate.getConverter()
            							.write(empleado, dbDoc); 
            						Query query = new Query()
            							.addCriteria(new Criteria("uuid")
            							.is(empleado.getEmpId())); // Se define la consulta 
            										// (Query) para encontrar el documento 
            										// correspondiente basado en el id
            						Update update = Update
            							.fromDocument(dbDoc, ""); // Operación de actualización
         							bulkOps.upsert(query, update); // Para insertar (si no 
         										// existe) o actualizar (si existe) el documento
            });

            // Ejecuta la actualización masiva en MongoDB.
            BulkWriteResult result = bulkOps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
