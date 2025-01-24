package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.ClienteDAO;
import com.luv2code.springboot.cruddemo.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Variable de tipo ClienteDAO (interfaz)
    private ClienteDAO clienteDAO;

    @Autowired
    public EmployeeServiceImpl(ClienteDAO theEmployeeDAO) {
        clienteDAO = theEmployeeDAO;
    }

    // Clientes corresponde al entity
    @Override
    public List<Clientes> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Clientes findById(int theId) {
        return clienteDAO.findById(theId);
    }

    @Transactional
    @Override
    public Clientes save(Clientes theEmployee) {
        return clienteDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        clienteDAO.deleteById(theId);
    }
}






