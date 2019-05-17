package com.halil.shoppingcart.dao.impl;


import com.halil.shoppingcart.dao.ProductDao;
import com.halil.shoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> getProducts() {
        return entityManager.createQuery("from Product").getResultList();
    }
}