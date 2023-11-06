package com.example.store.imp;


import com.example.store.model.Type;
import com.example.store.repository.TypeRepository;
import com.example.store.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository repository;

    @Override
    public List<Type> findAll() {
        return repository.findAll();
    }

    @Override
    public Type create(Type type) {
        return repository.save(type);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Type update(int id, Type type) {
        Optional<Type> existingTypeOptional = repository.findById(id);

        if (existingTypeOptional.isPresent()) {
        	Type existingType = existingTypeOptional.get();
            existingType.setTypeName(type.getTypeName());

            return repository.save(existingType);
        } else {
            return null;
        }
    }
}

