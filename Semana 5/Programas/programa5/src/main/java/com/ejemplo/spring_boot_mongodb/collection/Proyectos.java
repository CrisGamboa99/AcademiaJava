package com.ejemplo.spring_boot_mongodb.collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Proyectos {
	
	private String nombre;
	private String descripcion;
	private String fecha;
}
