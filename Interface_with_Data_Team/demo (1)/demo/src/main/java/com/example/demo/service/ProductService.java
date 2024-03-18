package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ShopperProductListDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Shopper;
import com.example.demo.entity.ShopperProductRelevance;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShopperProductRelevanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopperProductRelevanceRepository shopperProductRelevanceRepository;

    public void saveProductMetadata(ProductDTO productDto) {
        Product product = new Product(productDto.getProductId(),productDto.getCategory(),productDto.getBrand());
        productRepository.save(product);
    }

    public void saveShopperProductRelevance(ShopperProductListDTO shopperProductListDTO) {
        List<ShopperProductRelevance> shopperProductRelevances = shopperProductListDTO.getShelf().stream()
                .map(productRelevanceDTO -> {
                    ShopperProductRelevance spr = new ShopperProductRelevance();
                    spr.setShopper(new Shopper( (shopperProductListDTO.getShopperId() )));
                    spr.setProduct(new Product( ( productRelevanceDTO.getProductId()),null,null));
                    spr.setRelevancyScore(productRelevanceDTO.getRelevancyScore());
                    return spr;
                }).collect(Collectors.toList());
        shopperProductRelevanceRepository.saveAll(shopperProductRelevances);
    }
}
