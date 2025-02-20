package com.proyectoFinal.mongodbBulkUpdate.bo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("empleado")
public class EmpleadoBean {

	private String empId;
	private String empNombre;
	private String empDesc;
	private String salario;
	
}
