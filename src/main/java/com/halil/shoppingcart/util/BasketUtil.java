package com.halil.shoppingcart.util;

import com.halil.shoppingcart.model.Basket;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class BasketUtil {
    private static final String SESSION_KEY_SHOPPING_CART = "shoppingCart";

    public Basket getBasket(HttpSession session){
        Basket basket = (Basket) session.getAttribute(SESSION_KEY_SHOPPING_CART);

        if(basket == null){
            basket = new Basket();
            setBasket(session, basket);
        }

        return basket;
    }

    public void setBasket(HttpSession session, Basket basket){
        session.setAttribute(SESSION_KEY_SHOPPING_CART, basket);
    }

    public void removeBasket(HttpSession session){
        session.removeAttribute(SESSION_KEY_SHOPPING_CART);
    }

}
