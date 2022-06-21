package com.khoapham.service;

import com.khoapham.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void remove(int id);

    Page<Blog> search(String keyWord, Pageable pageable);
}
