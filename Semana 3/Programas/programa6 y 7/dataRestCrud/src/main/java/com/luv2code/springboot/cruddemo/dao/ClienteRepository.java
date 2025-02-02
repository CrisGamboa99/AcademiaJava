package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

// Al ser un crud con JPA, ya no es necesario poner nada la interfaz del paquete dao
// Támpoco es necesario crear una clase que implemente esta interfaz
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {


}
