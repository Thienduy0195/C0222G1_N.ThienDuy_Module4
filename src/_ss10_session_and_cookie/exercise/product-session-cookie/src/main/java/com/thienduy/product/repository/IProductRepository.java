package com.thienduy.product.repository;

import com.thienduy.product.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query(value = "select * from product where name like :productName", nativeQuery = true)
    List<Product> searchByProductName(@Param("productName") String productName);
}
