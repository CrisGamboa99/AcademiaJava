package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Clientes;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Clientes> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Clientes getEmployee(@PathVariable int employeeId) {

        Clientes theEmployee = employeeService.findById(employeeId);

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

        Clientes dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Clientes updateEmployee(@RequestBody Clientes theEmployee) {

        Clientes dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Clientes tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}














