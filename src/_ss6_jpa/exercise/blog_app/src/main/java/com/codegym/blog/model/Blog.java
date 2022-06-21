package com.codegym.blog.model;

import javax.persistence.*;

@Entity
@Table (name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String blogName;
    private String author;
    private String blogDescription;
    private String content;
    private String createDay;
    private Integer statusDelete;

    public Blog(Long id, String blogName, String author, String blogDescription, String content, String createDay, Integer statusDelete) {
        this.id = id;
        this.blogName = blogName;
        this.author = author;
        this.blogDescription = blogDescription;
        this.content = content;
        this.createDay = createDay;
        this.statusDelete = statusDelete;
    }

    public Blog() {
    }

    public Blog(String blogName, String author, String blogDescription, String content, String createDay, Integer statusDelete) {
        this.blogName = blogName;
        this.author = author;
        this.blogDescription = blogDescription;
        this.content = content;
        this.createDay = createDay;
        this.statusDelete = statusDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }
}
