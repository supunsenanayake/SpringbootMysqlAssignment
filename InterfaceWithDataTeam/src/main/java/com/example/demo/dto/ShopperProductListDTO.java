package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ShopperProductListDTO {
    @NotBlank(message = "Shopper ID cannot be blank")
    private String shopperId;
    @NotNull(message = "Shelf cannot be null")
    @Size(min = 1, message = "Shelf must contain at least one product")
    private List<@NotNull ProductRelevanceDTO> shelf;

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public List<ProductRelevanceDTO> getShelf() {
        return shelf;
    }

    public void setShelf(List<ProductRelevanceDTO> shelf) {
        this.shelf = shelf;
    }
// Getters and setters
}