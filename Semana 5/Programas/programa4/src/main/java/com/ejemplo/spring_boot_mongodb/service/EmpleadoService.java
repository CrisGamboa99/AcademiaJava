package com.ejemplo.spring_boot_mongodb.service;

import java.util.List;

import com.ejemplo.spring_boot_mongodb.collection.Empleado;

public interface EmpleadoService {

	String save(Empleado empleado);
	
	List<Empleado> getEmpleados();
	
	List<Empleado> getEmpleadoStartsWith(String nombre);
	
	void delete(String id);
	
	String update(Empleado empleado);
	
}
