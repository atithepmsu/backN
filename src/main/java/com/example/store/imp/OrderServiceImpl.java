package com.example.store.imp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.model.Order;
import com.example.store.repository.OrderRepository;
import com.example.store.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Order> findByProductId(int product_id) {
        return repository.findByProductId(product_id);
    }

    @Override
    public List<Order> findByCustomerId(int customer_id) {
        return repository.findByCustomerId(customer_id);
    }

    @Override
    public List<Order> findByEmployeeId(int employee_id) {
        return repository.findByEmployeeId(employee_id);
    }

    @Override
    public Order findById(int id) {
        Optional<Order> orderOptional = repository.findById(id);

        if (orderOptional.isPresent()) {
            return orderOptional.get();
        } else {
            
            return null;
        }
    }

    @Override
    public Order update(int id, Order order) {
        Optional<Order> existingOrderOptional = repository.findById(id);

        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();
            existingOrder.setOrderTotal(order.getOrderTotal());
            

            return repository.save(existingOrder);
        } else {
            
            return null;
        }
    }
}
