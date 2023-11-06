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

import com.example.store.model.Order;
import com.example.store.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService; 

    // GET ALL
    @GetMapping(value = "/orders/get/all")
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = orderService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // GET By ID
    @GetMapping("/orders/get/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("id") int id) {
        Order order = orderService.findById(id);

        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET By Product ID
    @GetMapping("/orders/get/{id}/products")
    public ResponseEntity<List<Order>> getOrderByProduct(@PathVariable("id") int product_id) {
        List<Order> orders = orderService.findByProductId(product_id);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // GET By Employee ID
    @GetMapping("/orders/get/{id}/employees")
    public ResponseEntity<List<Order>> getOrderByEmployee(@PathVariable("id") int customer_id) {
        List<Order> orders = orderService.findByEmployeeId(customer_id);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // GET By Customer ID
    @GetMapping("/orders/get/{id}/customers")
    public ResponseEntity<List<Order>> getOrderByCustomer(@PathVariable("id") int customer_id) {
        List<Order> orders = orderService.findByCustomerId(customer_id);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Add Order
    @PostMapping("/orders/save")
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    // Update Order
    @PutMapping("/orders/update/{id}")
    public Order update(@PathVariable("id") int id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    // Delete
    @DeleteMapping("/orders/{id}")
    public void delete(@PathVariable("id") int id) {
        orderService.delete(id);
    }
}
