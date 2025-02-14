package com.ejemplo.spring_boot_mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.spring_boot_mongodb.collection.Empleado;

@Repository
public interface EmpleadoRepository extends MongoRepository<Empleado, String> {
	
	List<Empleado> findByNombreStartsWith(String nombre);
	
}
