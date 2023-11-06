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

import com.example.store.model.Product;
import com.example.store.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products/get/all")
    public ResponseEntity<List<Product>> findAll() {
        
        List<Product> list = productService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/products/save")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/products/update/{id}")
    public Product update(@PathVariable("id") int id, @RequestBody Product product) {
        return productService.update(id, product); 
    }
    

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") int id) {
        productService.delete(id);
    }
}
