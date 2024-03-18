package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ShopperProductListDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Shopper;
import com.example.demo.entity.ShopperProductRelevance;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/productMetadata")
    public void addProductMetadata(@Valid @RequestBody ProductDTO product) {
        productService.saveProductMetadata(product);
    }


    @PostMapping("/shopperProductLists")
    public void addShopperProductList(@Valid @RequestBody ShopperProductListDTO shopperProductListDTO) {

        productService.saveShopperProductRelevance(shopperProductListDTO);
    }
}
