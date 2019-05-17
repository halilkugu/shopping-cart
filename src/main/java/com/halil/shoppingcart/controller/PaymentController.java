package com.halil.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

    @GetMapping("/payment/cc")
    public String payWithCC() {
        return "success-cc";
    }

    @GetMapping("payment/pp")
    public String payWithPP() {
        return "success-pp";
    }
}
