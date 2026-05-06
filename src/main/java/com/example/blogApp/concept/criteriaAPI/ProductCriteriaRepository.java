package com.example.blogApp.concept.criteriaAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long>,
        ProductRepositoryCustom {
}
