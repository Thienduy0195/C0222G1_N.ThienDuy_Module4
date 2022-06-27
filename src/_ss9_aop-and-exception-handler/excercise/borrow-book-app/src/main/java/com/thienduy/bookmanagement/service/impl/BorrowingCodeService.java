package com.thienduy.bookmanagement.service.impl;

import com.thienduy.bookmanagement.exception.NotFoundBorrowCode;
import com.thienduy.bookmanagement.model.BorrowingCode;
import com.thienduy.bookmanagement.repository.IBorrowingCodeRepository;
import com.thienduy.bookmanagement.service.IBorrowingCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowingCodeService implements IBorrowingCodeService {

    @Autowired
    IBorrowingCodeRepository borrowingCodeRepository;

    @Override
    public List<BorrowingCode> findAll() {
        return this.borrowingCodeRepository.findAll();
    }

    @Override
    public BorrowingCode findById(Integer id) throws NotFoundBorrowCode {
        BorrowingCode borrowingCode = this.borrowingCodeRepository.findById(id).get();
        if (borrowingCode != null) {
            return borrowingCode;
        }
        throw new NotFoundBorrowCode();
    }

    @Override
    public void saveBookCode(BorrowingCode borrowingCode) {
        Integer num = this.getBorrowingCode();
        LocalDate localDate = LocalDate.now();
        borrowingCode.setDateStart(String.valueOf(localDate));
        borrowingCode.setDateEnd(String.valueOf(localDate));
        borrowingCode.setBookCode(num);
        this.borrowingCodeRepository.save(borrowingCode);
    }

    @Override
    public void delete(BorrowingCode borrowingCode) {
        this.borrowingCodeRepository.delete(borrowingCode);
    }

    public Integer getBorrowingCode(){
        Integer num;
        while (true){
            num = (int) (Math.floor(Math.random() * 100000)-1);
            if (String.valueOf(num).length()==5){
                return num;
            }
        }
    }
}
