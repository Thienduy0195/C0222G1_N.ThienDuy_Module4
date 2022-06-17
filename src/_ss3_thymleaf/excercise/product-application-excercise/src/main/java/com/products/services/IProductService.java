package com.products.services;

import com.products.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Integer id, Product product);

    void remove(Integer id);

    Integer createId();

    List<Product> searchByName(String name);
}
