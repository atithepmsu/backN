package com.example.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { 
	// Change the type to Integer
}
