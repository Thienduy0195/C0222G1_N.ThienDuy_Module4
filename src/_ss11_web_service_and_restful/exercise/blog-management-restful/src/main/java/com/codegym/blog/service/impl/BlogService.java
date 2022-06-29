package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAllBlog();
    }

    @Override
    public Page<Blog> findAllBlogPage(Pageable pageable) {
        return blogRepository.findAllBlogPage(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.createNewBlog(blog.getAuthor(), blog.getBlogDescription(), blog.getBlogName(), blog.getContent(), blog.getCreateDay(), blog.getCategory().getId(), 1);
//        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.getBlogById(id);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteBlog(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.updateBlog(blog.getAuthor(), blog.getContent(), blog.getCreateDay(),
                blog.getBlogDescription(), blog.getBlogName(), blog.getCategory().getId(), blog.getId());
    }

    @Override
    public Page<Blog> searchBlog(String keyword, Pageable pageable) {
        return blogRepository.findAllByBlogNameContaining(keyword, pageable);
    }

    @Override
    public Page<Blog> searchByBlogName(String blogName, Pageable pageable) {
        return blogRepository.searchByBlogName("%" + blogName + "%", pageable);
    }


}
