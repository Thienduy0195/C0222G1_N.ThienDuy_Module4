package com.khoapham.service.impl;

import com.khoapham.model.Category;
import com.khoapham.repository.ICatelogyRepository;
import com.khoapham.service.ICategoryService;
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
