package com.example.store.service;

import java.util.List;

import com.example.store.model.Customer;

public interface CustomerService {
    List<Customer> findAll();
    Customer create(Customer customer);
    void delete(int id); 
    Customer update(int id, Customer customer);
}
