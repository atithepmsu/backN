package com.example.store.service;

import java.util.List;

import com.example.store.model.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Employee create(Employee employee);
    void delete(int id); 
    Employee update(int id, Employee employee);
}
