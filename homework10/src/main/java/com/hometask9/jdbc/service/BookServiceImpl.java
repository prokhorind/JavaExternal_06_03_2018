package com.hometask9.jdbc.service;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.dao.BookDAO;
import com.hometask9.jdbc.dao.BookDAOImpl;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

/**
 * Created by kleba on 12.04.2018.
 */
public class BookServiceImpl implements BookService{

    private BookDAO bookDAO;

    public BookServiceImpl(){
        bookDAO= new BookDAOImpl();
    }

    @Override
    public Connection connect(DB db) {
        return bookDAO.connect(db);
    }

    @Override
    public boolean persist(Object o) {
        return bookDAO.persist(o);
    }

    @Override
    public List<Book> searchBooksByAuthor(String name, String surname) {
        return bookDAO.searchBooksByAuthor(name,surname);
    }

    @Override
    public boolean deleteAuthorWithHisBooksById(long authorID) {
        return bookDAO.deleteAuthorWithHisBooksById(authorID);
    }

    @Override
    public boolean updateBookNameByBookId(String newName, long bookId) {
        return bookDAO.updateBookNameByBookId(newName,bookId);
    }

    @Override
    public Set<Author> getAllAuthors() {
        return bookDAO.getAllAuthors();
    }

    @Override
    public List<Book> getAllABooks() {
        return bookDAO.getAllABooks();
    }

    @Override
    public Connection getConnection() {
        return bookDAO.getConnection();
    }

    @Override
    public boolean closeConnection() {
        return bookDAO.closeConnection();
    }
}
