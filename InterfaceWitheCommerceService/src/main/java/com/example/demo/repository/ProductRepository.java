package com.example.demo.repository;


import com.example.demo.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT DISTINCT p FROM Product p JOIN ShopperProductRelevance spr ON p.productId = spr.product.productId " +
            "WHERE spr.shopper.shopperId = :shopperId " +
            "AND (:category IS NULL OR p.category = :category) " +
            "AND (:brand IS NULL OR p.brand = :brand) " +
            "ORDER BY spr.relevancyScore DESC" )
    List<Product> findProductsByShopperWithFilters(
            @Param("shopperId") String shopperId,
            @Param("category") String category,
            @Param("brand") String brand,
             Pageable pageable);
}