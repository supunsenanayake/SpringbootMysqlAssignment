package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/external/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Cacheable(value = "products", key = "#shopperId.concat(#category == null ? '' : #category).concat(#brand == null ? '' : #brand).concat(#limit.toString())")
    public List<Product> getProductsByCriteria(
            @RequestParam(required = true) String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        if ((category != null && category.trim().isEmpty()) || (brand != null && brand.trim().isEmpty())) {
            throw new ValidationException("Category and brand cannot be empty");

        }
        return productService.findProductsByCriteria(shopperId, category, brand, limit);
    }
}
