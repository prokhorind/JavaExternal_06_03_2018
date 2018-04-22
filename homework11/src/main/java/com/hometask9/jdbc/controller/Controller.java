package com.hometask9.jdbc.controller;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.service.BookService;
import com.hometask9.jdbc.service.BookServiceImpl;
import com.hometask9.jdbc.util.Books;
import com.hometask9.jdbc.util.xmlfactory.FactoryMethod;

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

    public boolean addAuthorWithAllHisBooks(Set<Book> bookSet){
        return bookService.addAuthorWithAllHisBooks(bookSet);
    }
    public int getTransactionType() {
        return bookService.getTransactionType();
    }

    public void setTransactionType(int transactionType) {
        bookService.setTransactionType(transactionType);
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

    public String booksToXml(){ return bookService.booksToXml(); }

    public boolean writeXmlFile(String xml){ return bookService.writeXmlFile(xml);}

    public Object readFromFile(String path){ return  bookService.readXmlFile(path);}

    public boolean validate(String xsdPath, String xmlPath){ return bookService.validate(xsdPath,xmlPath);}
    public Set<Book> checkBooks(Books books) {return bookService.checkBooks(books);
    }
    public void setFm(FactoryMethod fm) {
        bookService.setFm(fm);
    }

    public FactoryMethod getFm() {
        return bookService.getFm();
    }
     public String moneyCourse(String path){
         return bookService.moneyCourse(path);
     }
}
