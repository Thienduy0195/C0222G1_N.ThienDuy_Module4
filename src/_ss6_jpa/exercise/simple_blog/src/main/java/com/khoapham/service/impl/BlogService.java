package com.khoapham.service.impl;

import com.khoapham.model.Blog;
import com.khoapham.repository.IBlogRepository;
import com.khoapham.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null){
            blog.setDateCreate(LocalDate.now());
        }
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> search(String keyWord, Pageable pageable) {
        return this.iBlogRepository.findAllByNameContaining(keyWord,pageable);
    }
}
