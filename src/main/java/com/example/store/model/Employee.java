package com.example.store.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // Changed the id type to int

    @Column(unique = true)
    private String user; // Marked it as unique

    private String firstName; 
    private String lastName;

    private String password;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "create_at") 
//    private Date createdAt;
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = new Date();
//    }
    
}
