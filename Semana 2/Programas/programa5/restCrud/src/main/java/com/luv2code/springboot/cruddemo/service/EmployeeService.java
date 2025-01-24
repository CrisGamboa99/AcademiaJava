package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Clientes;

import java.util.List;

public interface EmployeeService {

    List<Clientes> findAll();

    Clientes findById(int theId);

    Clientes save(Clientes theEmployee);

    void deleteById(int theId);

}
