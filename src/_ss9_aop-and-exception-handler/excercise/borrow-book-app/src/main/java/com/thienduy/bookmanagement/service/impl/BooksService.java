package com.thienduy.bookmanagement.service.impl;

import com.thienduy.bookmanagement.exception.BookRunOut;
import com.thienduy.bookmanagement.model.Book;
import com.thienduy.bookmanagement.repository.IBooksRepository;
import com.thienduy.bookmanagement.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.sound.midi.MidiDevice;
import java.time.LocalDate;
import java.util.List;

@Service
public class BooksService implements IBooksService {
    @Autowired
    IBooksRepository booksRepository;

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Page<Book> findAllBookPage(Pageable pageable) {
        return booksRepository.findAllBookPage(pageable);
    }

    @Override
    public Book findById(Integer id) {
        return booksRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        LocalDate now;
        if(book.getPublishYear().equals("")){
            now = LocalDate.now();
            book.setPublishYear(String.valueOf(now));
        }
        booksRepository.save(book);
    }

    @Override
    public void borrow(Book book) throws BookRunOut {
        if (Integer.parseInt(book.getQuantity()) > 0 && book.getId() != null) {
            Integer num = Integer.parseInt(book.getQuantity())-1;
            book.setQuantity(String.valueOf(num));
            this.booksRepository.save(book);
        } else {
            throw new BookRunOut();
        }
    }

    @Override
    public void giveBack(Book books) {
        Integer num = Integer.parseInt(books.getQuantity()) +1;
        books.setQuantity(String.valueOf(num));
        this.booksRepository.save(books);
    }


}
