package com.example.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	// Change the type to Integer
}
