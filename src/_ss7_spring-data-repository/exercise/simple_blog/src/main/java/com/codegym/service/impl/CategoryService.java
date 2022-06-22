package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICatelogyRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICatelogyRepository iCatelogyRepository;

    @Override
    public List<Category> findAll() {
        return iCatelogyRepository.findAll();
    }
}
