package com.thienduy.bookmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "book_name")

    @NotEmpty
    @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of book!")
    private String nameBooks;

    private String author;

    @NotEmpty
    @Pattern(regexp = "^[0-9]+$", message = "Invalid book price!")
    private String price;

    @NotEmpty
    @Pattern(regexp = "^[0-9]+$", message = "Invalid book quantity!")
    private String quantity;

    private String publishYear;

    @OneToMany(mappedBy = "books")
    private List<BorrowingCode> borrowingCodes;

    public Book() {
    }

    public Book(Integer id, @NotEmpty @Pattern(regexp = "^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$", message = "Invalid name of book!") String nameBooks, String author, @NotEmpty @Pattern(regexp = "^[0-9]+$", message = "Invalid book price!") String price, @NotEmpty @Pattern(regexp = "^[0-9]+$", message = "Invalid book quantity!") String quantity, String publishYear, List<BorrowingCode> borrowingCodes) {
        this.id = id;
        this.nameBooks = nameBooks;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.publishYear = publishYear;
        this.borrowingCodes = borrowingCodes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBooks() {
        return nameBooks;
    }

    public void setNameBooks(String nameBooks) {
        this.nameBooks = nameBooks;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public List<BorrowingCode> getBorrowingCodes() {
        return borrowingCodes;
    }

    public void setBorrowingCodes(List<BorrowingCode> borrowingCodes) {
        this.borrowingCodes = borrowingCodes;
    }
}
