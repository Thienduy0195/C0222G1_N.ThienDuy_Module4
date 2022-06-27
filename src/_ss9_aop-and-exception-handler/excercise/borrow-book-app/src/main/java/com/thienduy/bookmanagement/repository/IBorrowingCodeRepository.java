package com.thienduy.bookmanagement.repository;

import com.thienduy.bookmanagement.model.BorrowingCode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IBorrowingCodeRepository extends JpaRepository<BorrowingCode,Integer> {

}
