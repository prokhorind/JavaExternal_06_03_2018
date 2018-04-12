package com.hometask9.jdbc.controller;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.service.BookService;
import com.hometask9.jdbc.service.BookServiceImpl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

/**
 * Created by kleba on 12.04.2018.
 */
public class Controller {

    private BookService bookService;

    public Controller(){
        bookService= new BookServiceImpl();
    }

    public Connection connect(DB db) {
        return bookService.connect(db);
    }

    public boolean persist(Object o) {
        return bookService.persist(o);
    }

    public List<Book> searchBooksByAuthor(String name, String surname) {
        return bookService.searchBooksByAuthor(name,surname);
    }

    public boolean deleteAuthorWithHisBooksById(long authorID) {
        return bookService.deleteAuthorWithHisBooksById(authorID);
    }

    public boolean updateBookNameByBookId(String newName, long bookId) {
        return bookService.updateBookNameByBookId(newName,bookId);
    }

    public Set<Author> getAllAuthors() {
        return bookService.getAllAuthors();
    }

    public List<Book> getAllABooks() {
        return bookService.getAllABooks();
    }

    public Connection getConnection() {
        return bookService.getConnection();
    }

    public boolean closeConnection() {
        return bookService.closeConnection();
    }
}
