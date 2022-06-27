package com.thienduy.bookmanagement.service;

import com.thienduy.bookmanagement.exception.NotFoundBorrowCode;
import com.thienduy.bookmanagement.model.BorrowingCode;

import java.util.List;
import java.util.Optional;

public interface IBorrowingCodeService {

    List<BorrowingCode> findAll();

    BorrowingCode findById(Integer id) throws NotFoundBorrowCode;

    void saveBookCode(BorrowingCode borrowingCode);

    void delete(BorrowingCode borrowingCode);
}
