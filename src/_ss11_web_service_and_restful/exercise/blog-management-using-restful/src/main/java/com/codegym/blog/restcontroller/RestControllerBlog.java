package com.codegym.blog.restcontroller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/goBlog")
public class RestControllerBlog {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> showListBlog(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("create_day").ascending();
        Page<Blog> blogList = iBlogService.findAllBlogPage(PageRequest.of(page, 3, sort));
        if (!blogList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/list-category")
    public ResponseEntity<Page<Category>> getCategory(
            @PageableDefault(value = 5) Pageable pageable) {
        Page<Category> categories = this.categoryService.findAllCategoryPage(pageable);
        if (!categories.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/list-category/{id}")
    public ResponseEntity<List<Blog>> getPagePosts(@PageableDefault(value = 2) Pageable pageable,
                                                        @PathVariable Integer id) {
        Category category = this.categoryService.findById(id);
        Set<Blog> blogSet =category.getBlogSet();
        List<Blog> blogModels = new ArrayList<>(blogSet);
        if (blogModels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogModels, HttpStatus.OK);
    }

    @GetMapping("/detail-blog/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable Long id) {
        Blog blogModel = this.iBlogService.findById(id);
        if (blogModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogModel, HttpStatus.OK);
    }

}
