package com.example.store.service;

import java.util.List;

import com.example.store.model.Order;

public interface OrderService {
    List<Order> findAll();
    Order create(Order order);
    void delete(int id); 
    Order update(int id, Order order);
    List<Order> findByProductId(int product_id);
    List<Order> findByEmployeeId(int product_id);
    List<Order> findByCustomerId(int customer_id);
    Order findById(int id);
}
