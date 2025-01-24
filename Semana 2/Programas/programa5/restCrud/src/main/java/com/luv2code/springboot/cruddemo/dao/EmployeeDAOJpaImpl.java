package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Clientes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Clientes> findAll() {

        // create a query
    	// Se cambia el from Employee a from Clientes para que concuerde con el nombre de la clase y sea reconocido
        TypedQuery<Clientes> theQuery = entityManager.createQuery("from Clientes", Clientes.class);

        // execute query and get result list
        List<Clientes> clientes = theQuery.getResultList();

        // return the results
        return clientes;
    }

    @Override
    public Clientes findById(int theId) {

        // get cliente
        Clientes elCliente = entityManager.find(Clientes.class, theId);

        // return cliente
        return elCliente;
    }

    @Override
    public Clientes save(Clientes theCliente) {

        // save cliente
        Clientes dbCliente = entityManager.merge(theCliente);

        // return the dbCliente
        return dbCliente;
    }

    @Override
    public void deleteById(int theId) {

        // find cliente by id
        Clientes elCliente = entityManager.find(Clientes.class, theId);

        // remove cliente
        entityManager.remove(elCliente);
    }
}











