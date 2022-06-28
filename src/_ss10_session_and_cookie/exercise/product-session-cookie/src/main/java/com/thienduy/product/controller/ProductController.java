package com.thienduy.product.controller;

import com.thienduy.product.model.Cart;
import com.thienduy.product.model.Product;
import com.thienduy.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shopnow");
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("add")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("minus")) {
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
//        String link = "redirect:/shop/" + productOptional.get().getId()+"/view";
//        return link;
        return "redirect:/shop";
    }

    @GetMapping("/shop/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        Product product = productService.findById(id).get();
        model.addAttribute("product", product);
        return "/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Long id,
                                 @ModelAttribute Cart cart) {
        Product product = productService.findById(id).get();
        cart.remove(product);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/pay")
    public String goPayment() {
        return "payment";
    }

    @GetMapping("/shop/search")
    public String searchByName(Product product, Model model) {
        List<Product> productList = productService.searchByProductName(product.getName());
        model.addAttribute("products", productList);
        return "/shopnow";
    }
}
