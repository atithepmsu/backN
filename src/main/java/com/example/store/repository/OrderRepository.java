package com.example.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByProductId(int product_id); // Change the type to Integer

    List<Order> findByCustomerId(int customer_id);

    List<Order> findByEmployeeId(int employee_id);
}
