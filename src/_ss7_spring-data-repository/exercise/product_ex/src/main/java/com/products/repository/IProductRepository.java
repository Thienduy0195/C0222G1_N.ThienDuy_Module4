package com.products.repository;

import com.products.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAllProduct();

    @Query(value = "select * from product", nativeQuery = true)
    Page<Product> findAllProductPage(Pageable pageable);

    @Query(value = "select * from product where product_id = :id", nativeQuery = true)
    Product getProductById(@Param("id") Long id);

    @Query(value = "delete from product where product_id=:id", nativeQuery = true)
    @Modifying
    void deleteProduct(@Param("id") Long id);

    @Query(value = "select * from product where product_name like :productName", nativeQuery = true)
    Page<Product> searchByProductName(@Param("productName") String productName, Pageable pageable);
}
