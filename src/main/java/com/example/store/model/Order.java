package com.example.store.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
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
@Table(name = "orders") // Changed table name to "orders" (plural)
@Getter
@Setter
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne
    @JoinColumn(name = "employee_id") // Join with "employee" table using "id" column
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "product_id") // Join with "product" table using "id" column
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id") // Join with "product" table using "id" column
    private Customer customer;

    @Column(name = "order_total")
    private int orderTotal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
    
    // Constructors, getters, setters, and other methods can remain the same.
}
