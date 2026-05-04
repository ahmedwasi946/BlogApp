package com.example.blogApp.concept.criteriaAPI;

import com.example.blogApp.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCriteriaRepository extends JpaRepository<Products, Long>,
        ProductCriteriaRepositoryCustom{
}
