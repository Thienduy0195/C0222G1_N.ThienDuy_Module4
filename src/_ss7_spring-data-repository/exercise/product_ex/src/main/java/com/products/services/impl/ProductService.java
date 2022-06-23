package com.products.services.impl;

import com.products.model.Product;
import com.products.repository.IProductRepository;
import com.products.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAllProduct();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.getProductById(id);
    }

    @Override
    public void remove(Long id) {
        iProductRepository.deleteProduct(id);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Page<Product> findAllProductPage(Pageable pageable) {
        return iProductRepository.findAllProductPage(pageable);
    }

    @Override
    public Page<Product> searchProduct(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> searchByProductName(String productName, Pageable pageable) {
        return iProductRepository.searchByProductName("%" + productName + "%", pageable);
    }
}
