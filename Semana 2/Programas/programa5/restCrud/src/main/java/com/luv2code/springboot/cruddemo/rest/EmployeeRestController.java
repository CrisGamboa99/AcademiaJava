package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Clientes;
import com.luv2code.springboot.cruddemo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private ClienteService clienteService;

    @Autowired
    public EmployeeRestController(ClienteService theEmployeeService) {
        clienteService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    // Clientes corresponde al entity
    @GetMapping("/employees")
    public List<Clientes> findAll() {
        return clienteService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Clientes getEmployee(@PathVariable int employeeId) {

        Clientes theEmployee = clienteService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/employees")
    public Clientes addEmployee(@RequestBody Clientes theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Clientes dbEmployee = clienteService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Clientes updateEmployee(@RequestBody Clientes theEmployee) {

        Clientes dbEmployee = clienteService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Clientes tempEmployee = clienteService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        clienteService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}














