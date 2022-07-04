package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/blog")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping(value = "/category")
    public String showListCategory(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Category> categoryList = categoryService.findAllCategoryPage(PageRequest.of(page, 10));
        model.addAttribute("category", new Blog());
        model.addAttribute("categoryList", categoryList);
        return "category/list";
    }

    @GetMapping(value = "/create-category")
    public String showFormCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/save-category")
    public String save(@ModelAttribute Category category, RedirectAttributes redirect) {
        categoryService.saveCategory(category);
        redirect.addFlashAttribute("success", "Create category successfully!");
        return "redirect:/blog/category";
    }
}
