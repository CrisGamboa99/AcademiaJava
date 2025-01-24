package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Clientes;

import java.util.List;

public interface ClienteDAO {

	// Los elementos de la lista son de tipo Cliente (entity)
    List<Clientes> findAll();

    // Clientes corresponde al entity
    Clientes findById(int theId);

    Clientes save(Clientes elCliente);

    void deleteById(int theId);
}










