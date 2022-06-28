package com.thienduy.product.service;

import com.thienduy.product.model.Product;

import java.util.Optional;

public interface IProductService {

    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
