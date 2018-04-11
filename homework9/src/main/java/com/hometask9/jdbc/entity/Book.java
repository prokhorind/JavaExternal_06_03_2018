package com.hometask9.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Created by kleba on 10.04.2018.
 */
@AllArgsConstructor
@ToString
public class Book {

    private long id;
    private String name;
    private int numberOfPages;
    private long authorId;

    public Book(){};

    public Book(String name, int numberOfPages, long authorId) {
        this.id = id;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", authorId=" + authorId +
                '}';
    }
}
