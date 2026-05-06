package com.example.blogApp.concept;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class DemoCriteriaAPIClass {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Products> getProducts(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Products> criteriaQuery = criteriaBuilder.createQuery(Products.class);

        Root<Products> root = criteriaQuery.from(Products.class);

        Predicate equal = criteriaBuilder.equal(root.get("name"), "Laptop");


        criteriaQuery.select(root).where(equal);

        TypedQuery<Products> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
