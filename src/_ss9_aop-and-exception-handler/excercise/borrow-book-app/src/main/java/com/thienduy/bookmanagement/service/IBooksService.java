package com.thienduy.bookmanagement.service;

import com.thienduy.bookmanagement.exception.BookRunOut;
import com.thienduy.bookmanagement.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBooksService {

    List<Book> findAll();

    Page<Book> findAllBookPage(Pageable pageable);

    Book findById(Integer id);

    void save(Book book);

    void borrow(Book book) throws BookRunOut;

    void giveBack(Book book);
}
