package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "select * from blog where statusDelete=1", nativeQuery = true)
    List<Blog> findAllBlog();

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog getBlogById(@Param("id") Long id);

    @Query(value = "insert into blog (author, blogDescription, blogName, content, createDay, statusDelete) " +
            "values (:author,:blogDescription,:blogName, :content, :createDay, :statusDelete);", nativeQuery = true)
    @Modifying
    void createNewBlog(@Param("author") String author,@Param("blogDescription") String blogDescription,
                       @Param("blogName") String blogName, @Param("content") String content, @Param("createDay") String createDay,
                        @Param("statusDelete") Integer statusDelete);

    @Query(value = "update blog set author=:author, content=:content, createDay=:createDay, blogDescription=:blogDescription, blogName=:blogName  where id=:id", nativeQuery = true)
    @Modifying
    void updateBlog(@Param("author") String author, @Param("content") String content, @Param("createDay") String createDay,
                       @Param("blogDescription") String blogDescription, @Param("blogName") String blogName, @Param("id") Long id);

    @Query(value = "update blog set statusDelete =0 where id=:id", nativeQuery = true)
    @Modifying
    void deleteBlog(@Param("id") Long id);
}
