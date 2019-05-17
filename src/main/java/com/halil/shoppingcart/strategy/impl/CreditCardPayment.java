package com.halil.shoppingcart.strategy.impl;

import com.halil.shoppingcart.strategy.PaymentMethod;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public String pay(Double amount) {
        return "You have paid with credit card.";
    }
}
