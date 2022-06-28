package com.thienduy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String goToShop() {
        return "redirect:/shop";
    }
}
