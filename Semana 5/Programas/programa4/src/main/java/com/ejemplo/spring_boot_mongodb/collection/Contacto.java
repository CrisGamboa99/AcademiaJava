package com.ejemplo.spring_boot_mongodb.collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contacto {
	
	private String telefono1;
	private String telefono2;
	private String correo;
	
}
