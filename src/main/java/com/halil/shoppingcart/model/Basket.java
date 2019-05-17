package com.halil.shoppingcart.model;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Basket {

    private static final Double KDV_RATIO = 10.0;
    private static final Double SHIPPING_PRICE = 6.5;

    private List<BasketItem> basketItems = new ArrayList<>();
    private Double totalPrice;

    public void removeProduct(BasketItem basketItem){ // throws ProductNotFoundException
        if (basketItem != null){
            basketItems.remove(basketItem);
        } else {
            // throw new ProductNotFoundException();
        }
    }

    public BasketItem getBasketItem(int productId) {
        for (BasketItem basketItem : basketItems) {
            if (basketItem.getProduct().getId().equals(productId)) {
                return basketItem;
            }
        }
        return null;
    }

    public BasketItem getBasketItem(Product product){
        for (BasketItem basketItem : basketItems){
            if(basketItem.getProduct().getId().equals(product.getId())){
                return basketItem;
            }
        }
        return null;
    }


    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        basketItems = basketItems;
    }

    public Double calculateBasketSubTotal() {
        return getTotalPrice();
    }
    public Double calculateBasketKdv() {
        return (getTotalPrice() * KDV_RATIO) / 100;
    }

    public Double calculateBasketTotal() {
        return calculateBasketSubTotal() + calculateBasketKdv() + getShippingPrice();
    }

    public Double getTotalPrice() {
        Double totalPrice = 0.0;
        for (BasketItem bi : basketItems) {
            totalPrice += bi.getQuantity() * bi.getProduct().getPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getShippingPrice() {
        if (!(basketItems.size() > 0)) {
            return Double.valueOf(0);
        }
        return SHIPPING_PRICE;
    }
}
