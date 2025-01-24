package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Clientes;

import java.util.List;

public interface EmployeeDAO {

    List<Clientes> findAll();

    Clientes findById(int theId);

    Clientes save(Clientes elCliente);

    void deleteById(int theId);
}










