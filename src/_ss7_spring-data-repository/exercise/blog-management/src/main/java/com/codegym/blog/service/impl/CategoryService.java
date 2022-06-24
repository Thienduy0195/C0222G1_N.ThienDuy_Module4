package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.ICategoryRepository;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findAllCategoryPage(Pageable pageable) {
        return categoryRepository.findAllCategoryPage(pageable);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }


}
