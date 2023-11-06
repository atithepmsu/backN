package com.example.store.service;

import java.util.List;

import com.example.store.model.Product;

public interface ProductService {
    List<Product> findAll();
    Product create(Product product);
    void delete(int id); 
    Product update(int id, Product product);
}
