package com.example.store.service;

import com.example.store.model.Type;
import java.util.List;

public interface TypeService {
    List<Type> findAll();
    Type create(Type type);
    void delete(int id);
    Type update(int id, Type type);
}
