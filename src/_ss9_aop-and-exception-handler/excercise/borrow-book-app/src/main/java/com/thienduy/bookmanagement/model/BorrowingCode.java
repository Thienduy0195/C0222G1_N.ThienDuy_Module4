package com.thienduy.bookmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "borrowing_code")
public class BorrowingCode {
    @Id
    @Column(name = "book_code")
    private Integer bookCode;
    @Column(name = "date_start")
    private String dateStart;
    @Column(name = "date_end")
    private String dateEnd;

    @ManyToOne()
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book books;

    public BorrowingCode() {
    }

    public BorrowingCode(Integer bookCode, String dateStart, String dateEnd, Book books) {
        this.bookCode = bookCode;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.books = books;
    }

    public Integer getBookCode() {
        return bookCode;
    }

    public void setBookCode(Integer bookCode) {
        this.bookCode = bookCode;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }
}
