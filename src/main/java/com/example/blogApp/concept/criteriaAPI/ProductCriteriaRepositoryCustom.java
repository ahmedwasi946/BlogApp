package com.example.blogApp.concept.criteriaAPI;

import com.example.blogApp.entity.Products;

import java.util.List;

public interface ProductCriteriaRepositoryCustom {
    List<Products> searchProducts(String name,
                                  Double minPrice,
                                  Double maxPrice,
                                  String category);
}
