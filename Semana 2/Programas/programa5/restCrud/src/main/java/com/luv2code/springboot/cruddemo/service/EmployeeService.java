package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Clientes;

import java.util.List;

public interface EmployeeService {

	// Clientes corresponde al entity
    List<Clientes> findAll();

    Clientes findById(int theId);

    Clientes save(Clientes theEmployee);

    void deleteById(int theId);

}
