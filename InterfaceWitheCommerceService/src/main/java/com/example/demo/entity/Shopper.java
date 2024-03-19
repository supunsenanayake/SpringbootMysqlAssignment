package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shopper {

    @Id
    private String shopperId;


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


}
