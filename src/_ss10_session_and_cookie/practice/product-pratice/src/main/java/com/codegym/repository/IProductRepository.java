package com.codegym.repository;


import com.codegym.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}