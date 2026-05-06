package com.example.blogApp.concept.criteriaAPI;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    @Autowired
private ProductCriteriaRepository productCriteriaRepository;

public List<Products> search(String name, Double min, Double max, String category){
   return productCriteriaRepository.searchProducts(name, min, max, category);
    }
}