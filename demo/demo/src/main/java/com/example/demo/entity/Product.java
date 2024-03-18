package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "Products")
public class Product {
    @Id
    private String productId;
    private String name;
    private String category;
    private String brand;
    // Constructors, Getters, and Setters
}

