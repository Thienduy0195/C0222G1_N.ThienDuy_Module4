package com.products.services;

import com.products.model.Product;
import com.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.remove(id);
    }

    @Override
    public Integer createId() {
        //get the last item in product list
        Product product = this.findAll().get(this.findAll().size() - 1);
        //return the last id (from last product) inlist + 1
        return product.getProductId() + 1;
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}
