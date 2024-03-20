package com.example.demo.repository;

import com.example.demo.entity.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperRepository extends JpaRepository<Shopper, String> {
}
