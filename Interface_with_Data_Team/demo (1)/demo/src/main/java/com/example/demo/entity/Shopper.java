package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shopper {

    @Id
    private String shopperId;
    // Consider adding more shopper-specific fields here, e.g., name, email

    // Default constructor
    public Shopper() {}

    // Constructor, getters and setters
    public Shopper(String shopperId) {
        this.shopperId = shopperId;
    }

    // Getters and setters
    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    // Additional getters and setters for other fields
}
