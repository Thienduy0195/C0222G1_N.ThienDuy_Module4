package com.codegym.blog.repository;

import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from category", nativeQuery = true)
    Page<Category> findAllCategoryPage(Pageable pageable);
}
