package com.example.store.imp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.model.Employee;
import com.example.store.repository.EmployeeRepository;
import com.example.store.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    private EmployeeRepository repository;
    
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Employee update(int id, Employee employee) {
        Optional<Employee> existingEmployeeOptional = repository.findById(id);

        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setUser(employee.getUser());
            existingEmployee.setPassword(employee.getPassword());
            

            return repository.save(existingEmployee);
        } else {
            
            return null;
        }
    }
}
