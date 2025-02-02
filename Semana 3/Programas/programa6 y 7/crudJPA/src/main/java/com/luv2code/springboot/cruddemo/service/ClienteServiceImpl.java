package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.ClienteRepository;
import com.luv2code.springboot.cruddemo.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService { // Implementa la interfaz del service

	// Variable de tipo ClienteDAO (interfaz)
    private ClienteRepository clienteRepository;

    // El nombre del constructor cambia para concordar con el nuevo nombre de la clase
    @Autowired
    public ClienteServiceImpl(ClienteRepository elClienteRepository) {
    	clienteRepository = elClienteRepository;
    }

    // Clientes corresponde al entity
    @Override
    public List<Clientes> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Clientes findById(int theId) {
        Optional<Clientes> result = clienteRepository.findById(theId);

        Clientes elCliente = null;

        if (result.isPresent()) {
        	elCliente = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find cliente id - " + theId);
        }

        return elCliente;
    }

    @Transactional
    @Override
    public Clientes save(Clientes elCliente) {
        return clienteRepository.save(elCliente);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
    	clienteRepository.deleteById(theId);
    }
}






