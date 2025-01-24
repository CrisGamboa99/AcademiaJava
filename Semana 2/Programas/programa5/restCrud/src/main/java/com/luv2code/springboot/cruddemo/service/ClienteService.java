package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Clientes;

import java.util.List;

public interface ClienteService {

	// Clientes corresponde al entity
    List<Clientes> findAll();

    Clientes findById(int theId);

    Clientes save(Clientes elCliente);

    void deleteById(int theId);

}
