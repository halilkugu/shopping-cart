package com.halil.shoppingcart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BasketItem {

    private int quantity;
    private Product product;

    public BasketItem(Date createDate, Date updateDate, int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public BasketItem() {
    }

    public Double getTotal() {
        return product.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
