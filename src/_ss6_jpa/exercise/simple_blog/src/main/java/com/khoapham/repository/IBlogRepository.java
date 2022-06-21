package com.khoapham.repository;

import com.khoapham.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

//    @Query(value = "select b.* " +
//            "from blog as b " +
//            "where b.name " +
//            "like :nameSearch",nativeQuery = true)
    //    Page<Blog> findAllByNameContaining(@Param("nameSearch") String keyword, Pageable pageable);

    Page<Blog> findAllByNameContaining(String keyword, Pageable pageable);
}
