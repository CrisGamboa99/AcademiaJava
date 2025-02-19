package com.proyectoFinal.springBatch.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoBean {

	private String empId;
	private String empNombre;
	private String empDesc;
	private String salario;
	
}
