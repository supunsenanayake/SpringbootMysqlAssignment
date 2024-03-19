package com.example.demo.entity;
import java.io.Serializable;

public class ShopperProductId implements Serializable {
    private String shopper;
    private String product;

    // Default constructor
    public ShopperProductId() {}

    // Constructor, getters and setters, equals(), and hashCode() methods
    public ShopperProductId(String shopper, String product) {
        this.shopper = shopper;
        this.product = product;
    }

    // Getters and setters
    public String getShopper() {
        return shopper;
    }

    public void setShopper(String shopper) {
        this.shopper = shopper;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

}
