package com.thienduy.product.service.impl;

import com.thienduy.product.model.Product;
import com.thienduy.product.repository.IProductRepository;
import com.thienduy.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
