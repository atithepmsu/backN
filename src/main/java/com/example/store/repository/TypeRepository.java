package com.example.store.repository;

import com.example.store.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    // You can define custom query methods here if needed
}