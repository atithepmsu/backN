package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.model.Employee;
import com.example.store.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees/get/all")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> list = employeeService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
//    @GetMapping(value = "/employees/get/{id}")
//    public ResponseEntity<List<Employee>> findByID() {
//        List<Employee> list = employeeService.findByid();
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }

    @PostMapping("/employees/save")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/employees/update/{id}")
    public Employee update(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable("id") int id) {
        employeeService.delete(id);
    }
}
