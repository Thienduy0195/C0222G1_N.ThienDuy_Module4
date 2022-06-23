package com.products.controller;

import com.products.model.Product;
import com.products.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

//    @GetMapping("")
//    public String index(Model model) {
//        List<Product> productList = productService.findAll();
//        model.addAttribute("product", new Product());
//        model.addAttribute("productList", productList);
//        return "index";
//    }

    @GetMapping
    public String showListProduct(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("product_firm").ascending();
        Page<Product> productList = productService.findAllProductPage(PageRequest.of(page, 3, sort));
        model.addAttribute("product", new Product());
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated  Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Create product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@Validated Product product, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/update";
        }
        productService.save(product);
        redirect.addFlashAttribute("success", "Updating product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, Model model, RedirectAttributes redirect) {
        productService.remove(product.getProductId());
        List<Product> productList = productService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("productList", productList);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "page", defaultValue = "0") int page,
                               Product product, Model model) {
        Pageable pageable;
        Sort sort = Sort.by("product_firm").ascending();
        pageable = PageRequest.of(page, 10, sort);
        Page<Product> productList = productService.searchByProductName(product.getProductName(), pageable);
        model.addAttribute("productList", productList);
        return "index";
    }

//    @GetMapping("/search")
//    public String searchByName(Product product, Model model) {
//        List<Product> productList = productService.searchByProductName(product.getProductName());
//        model.addAttribute("productList", productList);
//        return "index";
//    }
}
