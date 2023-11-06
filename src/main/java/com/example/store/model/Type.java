package com.example.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "type")
@Getter
@Setter
public class Type {
    @Id
    private int id; // Primary key
    private String typeName;

    // Constructors, getters, setters, and other properties
}