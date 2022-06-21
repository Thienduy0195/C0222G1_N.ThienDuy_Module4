package com.khoapham.controller;

import com.khoapham.model.Blog;
import com.khoapham.service.IBlogService;

import com.khoapham.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String index(Model model,
                        @RequestParam(defaultValue = "0") Integer page,
                        @RequestParam(defaultValue = "3") Integer pageSize,
                        @RequestParam(defaultValue = "author") String sort,
                        @RequestParam(defaultValue = "asc") String dir,
                        @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");

        Pageable pageable;

        if (dir.equals("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sort).descending());
        }

        Page<Blog> productList = iBlogService.search(keywordVal, pageable);

        model.addAttribute("blogs", productList);
        model.addAttribute("keywordVal", keywordVal);
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", this.iCategoryService.findAll());
        return "/create";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        iBlogService.save(blog);
        redirect.addFlashAttribute("success", "Create blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        iBlogService.save(blog);
        redirect.addFlashAttribute("success", "Update blog successfully!");

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        iBlogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/view";
    }
}
