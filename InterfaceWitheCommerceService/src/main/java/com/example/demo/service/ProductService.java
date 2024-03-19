package com.example.demo.service;


import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProductsByCriteria(String shopperId, String category, String brand, Integer limit) {

        Pageable pageable = PageRequest.of(0, Math.min(limit, 100));

        return productRepository.findProductsByShopperWithFilters(shopperId, category, brand, pageable);
    }

}
