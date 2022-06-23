package com.products.services;

import com.products.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Long id);

    void remove(Long id);

    void update(Product product);

    Page<Product> findAllProductPage(Pageable pageable);

    Page<Product> searchProduct(String keyword, Pageable pageable);

    Page<Product> searchByProductName(String productName, Pageable pageable);
}
