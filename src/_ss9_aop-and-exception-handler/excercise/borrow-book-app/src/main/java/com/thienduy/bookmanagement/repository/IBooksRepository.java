package com.thienduy.bookmanagement.repository;

import com.thienduy.bookmanagement.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface
IBooksRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from books", nativeQuery = true)
    Page<Book> findAllBookPage(Pageable pageable);

    Page<Book> findAllByNameBooksContaining(String keywordName, Pageable pageable);
}
