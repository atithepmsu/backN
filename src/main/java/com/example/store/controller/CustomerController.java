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

import com.example.store.model.Customer;
import com.example.store.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService; 

    @GetMapping(value = "/customers/get/all") //1
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> list = customerService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
//    @GetMapping(value = "/customers/get/{id}") //2
//    public ResponseEntity<List<Customer>> findByID() {
//        List<Customer> list = customerService.findByID();
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }

    @PostMapping("/customers/save") //2
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PutMapping("/customers/update/{id}")//3
    public Customer update(@PathVariable("id") int id, @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/customers/{id}")//4
    public void delete(@PathVariable("id") int id) {
        customerService.delete(id);
    }
}
