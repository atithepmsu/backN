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
@Table(name = "customer")
@Getter
@Setter
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    @Column(unique = true)
    private String c_user; 

    private String firstName; 
    private String lastName;

    private String password;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "create_at") // Changed the field name to 'create_at'
//    private Date createdAt;
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = new Date();
//    }
    
    // Constructors, getters, setters, and other methods can remain the same.
}
