package com.halil.shoppingcart.controller;


import com.halil.shoppingcart.model.Basket;
import com.halil.shoppingcart.model.BasketItem;
import com.halil.shoppingcart.model.Product;
import com.halil.shoppingcart.service.ProductService;
import com.halil.shoppingcart.util.BasketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class BasketController {

    private static Logger logger = Logger.getLogger(BasketController.class.getName());

    @Autowired
    private ProductService productService;

    @Autowired
    private BasketUtil basketUtil;

    @GetMapping("/")
    public String basket(HttpSession session, Model model) {
        List<Product> products = productService.getProducts();
        Basket basket = new Basket();
        for (Product product : products) {
            BasketItem basketItem = new BasketItem(new Date(), new Date(), 1, product);
            basket.getBasketItems().add(basketItem);
        }
        basketUtil.setBasket(session, basket);

        return "basket";
    }

    @PostMapping("/update-quantity")
    public String updateQuantity(Model model, HttpSession session, @RequestParam("id") int productId , @RequestParam("quantity") int quantity) {
        Basket basket = basketUtil.getBasket(session);

        BasketItem basketItem = basket.getBasketItem(productId);
        if (quantity == 0) {
            basket.removeProduct(basketItem);
        } else {
            basketItem.setQuantity(quantity);
        }

        return "basket";
    }


    @GetMapping("/remove/{id}")
    public String remove(Model model, HttpSession session, @PathVariable("id") int productId) {
        Basket basket = basketUtil.getBasket(session);

        BasketItem basketItem = basket.getBasketItem(productId);
        basket.removeProduct(basketItem);

        return "basket";
    }


}
