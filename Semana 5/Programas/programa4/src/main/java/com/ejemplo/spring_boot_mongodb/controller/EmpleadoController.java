package com.ejemplo.spring_boot_mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.spring_boot_mongodb.collection.Empleado;
import com.ejemplo.spring_boot_mongodb.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping
	public String save(@RequestBody Empleado empleado) {
		return empleadoService.save(empleado);
	}
	
	@GetMapping("/all")
	public List<Empleado> getEmpleados() {
		return empleadoService.getEmpleados();
	}
	
	@GetMapping
	public List<Empleado> getEmpleadoStartsWith(@RequestParam("nombre") String nombre) {
		return empleadoService.getEmpleadoStartsWith(nombre);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		empleadoService.delete(id);
	}
	
	@PutMapping
	public String update(@RequestBody Empleado empleado) {
		return empleadoService.update(empleado);
	}
	
}
