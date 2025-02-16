package com.ejemplo.spring_boot_mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.spring_boot_mongodb.collection.Empleado;
import com.ejemplo.spring_boot_mongodb.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public String save(Empleado empleado) {
		empleadoRepository.save(empleado);
		return empleado.getId();
	}
	
	@Override
	public List<Empleado> getEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public List<Empleado> getEmpleadoStartsWith(String nombre) {
		return empleadoRepository.findByNombreStartsWith(nombre);
	}

	@Override
	public void delete(String id) {
		empleadoRepository.deleteById(id);
	}
	
	@Override
	public String update(Empleado empleado) {
		Empleado emp = empleadoRepository.findById(empleado.getId())
						.orElseThrow(() -> 
						new RuntimeException("No se pudo encontrar "
								+ "el Empleado con el id " + empleado.getId()));
		
		emp.setNombre(empleado.getNombre());
		emp.setApellido(empleado.getApellido());
		emp.setEdad(empleado.getEdad());
		emp.setPuesto(empleado.getPuesto());
		emp.setContacto(empleado.getContacto());
		emp.setProyectos(empleado.getProyectos());
		
		empleadoRepository.save(empleado);
		return empleado.getId();
		
	}
	
}
