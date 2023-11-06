package com.example.store.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // Change the id type to int
    
    private String img;

    private String productName;
    private String size;
    private int price;
//    private int type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @ManyToOne
    @JoinColumn(name = "type_id") // Join with "product" table using "id" column
    private Type type;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    // Constructors, getters, setters, and other methods can remain the same.
}
