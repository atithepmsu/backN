package com.example.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> { 
	// Change the type to Integer
}
