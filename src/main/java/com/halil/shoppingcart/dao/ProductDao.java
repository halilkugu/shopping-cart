package com.halil.shoppingcart.dao;


import com.halil.shoppingcart.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

}