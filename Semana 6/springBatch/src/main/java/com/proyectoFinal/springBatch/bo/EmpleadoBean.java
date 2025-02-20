package com.proyectoFinal.springBatch.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity. Para indicar los campos de la tabla

@Data // Genera de forma automatica los métodos de la clase como constructor, getters, setters
@NoArgsConstructor // Para generar un constructor sin atributos
@AllArgsConstructor // Para generar un constructor con todos los atributos
public class EmpleadoBean {

	private String empId;
	private String empNombre;
	private String empDesc;
	private String salario;
	
}
