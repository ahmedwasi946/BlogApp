package com.example.blogApp.concept.criteriaAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCriteriaRepository extends JpaRepository<Products, Long>,
        ProductCriteriaRepositoryCustom{
}
