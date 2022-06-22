package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void remove(Long id);

    void update(Blog blog);

    Page<Blog> findAllBlogPage(Pageable pageable);

    Page<Blog> searchBlog(String keyword, Pageable pageable);

    Page <Blog> searchByBlogName(String blogName, Pageable pageable);
}
