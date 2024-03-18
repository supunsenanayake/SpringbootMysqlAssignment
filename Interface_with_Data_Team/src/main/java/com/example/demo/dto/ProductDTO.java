package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class ProductDTO {

    @NotBlank(message = "Product ID cannot be blank")
    private String productId;

    @NotBlank(message = "Category cannot be blank")
    @Size(max = 100, message = "Category must be less than 100 characters")
    private String category;

    @NotBlank(message = "Brand cannot be blank")
    @Size(max = 100, message = "Brand must be less than 100 characters")
    private String brand;

    // Default constructor
    public ProductDTO() {}

    // Constructor with fields
    public ProductDTO(String productId, String category, String brand) {
        this.productId = productId;
        this.category = category;
        this.brand = brand;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
