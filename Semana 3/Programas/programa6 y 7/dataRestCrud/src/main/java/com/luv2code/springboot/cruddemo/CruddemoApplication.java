package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	// Al hacer uso de spring data rest ya no es necesario crear clases de RestController ni de Service
	
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}
