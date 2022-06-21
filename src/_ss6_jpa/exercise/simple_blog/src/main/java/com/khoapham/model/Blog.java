package com.khoapham.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String descriptionBlog;
    private String content;
    private LocalDate dateCreate;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String name, String author, String descriptionBlog, String content, LocalDate dateCreate, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.descriptionBlog = descriptionBlog;
        this.content = content;
        this.dateCreate = dateCreate;
        this.category = category;
    }

    public Blog(String name, String author, String descriptionBlog, String content, LocalDate dateCreate, Category category) {

        this.name = name;
        this.author = author;
        this.descriptionBlog = descriptionBlog;
        this.content = content;
        this.dateCreate = dateCreate;
        this.category = category;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptionBlog() {
        return descriptionBlog;
    }

    public void setDescriptionBlog(String descriptionBlog) {
        this.descriptionBlog = descriptionBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}