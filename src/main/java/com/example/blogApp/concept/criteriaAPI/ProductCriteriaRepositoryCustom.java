package com.example.blogApp.concept.criteriaAPI;

import java.util.List;

public interface ProductCriteriaRepositoryCustom {
    List<Products> searchProducts(String name,
                                  Double minPrice,
                                  Double maxPrice,
                                  String category);
}
