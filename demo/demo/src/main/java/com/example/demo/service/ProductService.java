package com.example.demo.service;


import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProductsByCriteria(String category, String brand, Integer limit) {
        // Apply the limit as a PageRequest. If limit is not provided, use a default value or omit pagination.
        int size = (limit != null) ? limit : 10; // Assuming a default limit of 10 if none is provided
        PageRequest pageRequest = PageRequest.of(0, size);

        // Adjusting the repository call to use findAll instead of the custom method, for simplicity
        // Note: This is a conceptual adjustment. You'll need to customize the query to handle pagination if using a custom query method.
        return productRepository.findByCategoryAndBrand(category, brand, pageRequest).getContent();
    }
    // Other methods...
}
