package com.thienduy.product.repository;

import com.thienduy.product.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;


@Transactional
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {


}
