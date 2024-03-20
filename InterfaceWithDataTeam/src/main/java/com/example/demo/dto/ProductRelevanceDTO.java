package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductRelevanceDTO {
    @NotBlank(message = "Product ID cannot be blank")
    private String productId;
    private double relevancyScore;

    public ProductRelevanceDTO(String productId, double relevancyScore) {
        this.productId = productId;
        this.relevancyScore = relevancyScore;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }
// Getters and setters
}