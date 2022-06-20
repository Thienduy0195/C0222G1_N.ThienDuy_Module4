package com.products.repository;

import com.products.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(Long id);

    void update(Product product);

    void delete(Product product);

    List<Product> searchByName(String name);
}
