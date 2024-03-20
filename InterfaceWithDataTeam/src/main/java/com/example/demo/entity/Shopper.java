package com.example.demo.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Shopper {
    public Shopper() {
    }

    public Shopper(String shopperId) {
        this.shopperId = shopperId;
    }

    @Id
    private String shopperId;
    @OneToMany(mappedBy = "shopper", cascade = CascadeType.ALL)
    private List<ShopperProductRelevance> shelf;

    public List<ShopperProductRelevance> getShelf() {
        return shelf;
    }

    public void setShelf(List<ShopperProductRelevance> shelf) {
        this.shelf = shelf;
    }

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }


}
