package com.example.demo.entity;

import jakarta.persistence.*;



@Entity
@IdClass(ShopperProductId.class)
public class ShopperProductRelevance {

    @Id
    @ManyToOne
    @JoinColumn(name = "shopperId", referencedColumnName = "shopperId")
    private Shopper shopper;

    @Id
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;

    private double relevancyScore;

    // Default constructor
    public ShopperProductRelevance() {}

    // Constructor, getters and setters
    public ShopperProductRelevance(Shopper shopper, Product product, float relevancyScore) {
        this.shopper = shopper;
        this.product = product;
        this.relevancyScore = relevancyScore;
    }

    // Getters and setters
    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }
}
