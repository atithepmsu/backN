package com.example.store.imp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.model.Customer;
import com.example.store.repository.CustomerRepository;
import com.example.store.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Customer update(int id, Customer customer) {
        Optional<Customer> existingCustomerOptional = repository.findById(id);

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setC_user(customer.getC_user());
            existingCustomer.setPassword(customer.getPassword());

            return repository.save(existingCustomer);
        } else {
            
            return null;
        }
    }
}
