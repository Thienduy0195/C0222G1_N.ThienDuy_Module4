package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "select * from blog", nativeQuery = true)
    List<Blog> findAllBlog();

    @Query(value = "select * from blog", nativeQuery = true)
    Page<Blog> findAllBlogPage(Pageable pageable);

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog getBlogById(@Param("id") Long id);

    @Query(value = "insert into blog (author, blog_description, blog_name, content, create_day, category_id, status_delete) " +
            "values (:author,:blogDescription,:blogName, :content, :createDay,:categoryId,  :statusDelete);", nativeQuery = true)
    @Modifying
    void createNewBlog(@Param("author") String author, @Param("blogDescription") String blogDescription,
                       @Param("blogName") String blogName, @Param("content") String content, @Param("createDay") String createDay,
                       @Param("categoryId") Integer categoryId, @Param("statusDelete") Integer statusDelete);

    @Query(value = "update blog set author=:author, content=:content, create_day=:createDay, blog_description=:blogDescription, blog_name=:blogName,category_id=:categoryId where id=:id", nativeQuery = true)
    @Modifying
    void updateBlog(@Param("author") String author, @Param("content") String content, @Param("createDay") String createDay,
                    @Param("blogDescription") String blogDescription, @Param("blogName") String blogName, @Param("categoryId") Integer categoryId, @Param("id") Long id);

    @Query(value = "update blog set status_delete =0 where id=:id", nativeQuery = true)
    @Modifying
    void deleteBlog(@Param("id") Long id);

    Page<Blog> findAllByBlogNameContaining(String keyword, Pageable pageable);

//    @Query(value = "select * from blog where blog_name like :blogName", nativeQuery = true)
//    Page<Blog> searchByBlogName(@Param("blogName") String blogName, Pageable pageable);

    @Query(value = "select * from blog where blog_name like :blogName", nativeQuery = true)
    List<Blog> searchByBlogName(@Param("blogName") String blogName);
}
