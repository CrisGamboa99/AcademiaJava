package com.ejemplo.spring_boot_mongodb.collection;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Document(collection = "empleado")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Empleado {
	
	@Id
	private String id;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String puesto;
	private List<Contacto> contacto;
	private List<Proyectos> proyectos;
	
}
