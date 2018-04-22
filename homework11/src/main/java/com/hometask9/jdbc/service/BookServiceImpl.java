package com.hometask9.jdbc.service;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.dao.BookDAO;
import com.hometask9.jdbc.dao.BookDAOImpl;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.util.Books;
import com.hometask9.jdbc.util.xmlfactory.AbstractXML;
import com.hometask9.jdbc.util.xmlfactory.FactoryMethod;
import com.hometask9.jdbc.util.xmlfactory.JaxbXml;
import com.hometask9.jdbc.util.xmlfactory.SaxXml;

import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;

/**
 * Created by kleba on 12.04.2018.
 */
public class BookServiceImpl implements BookService{

    private BookDAO bookDAO;

    private FactoryMethod fm;
    public BookServiceImpl(){
        bookDAO= new BookDAOImpl();
    }

    public void setFm(FactoryMethod fm) {
        this.fm = fm;
    }

    public FactoryMethod getFm() {
        return fm;
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
    public boolean addAuthorWithAllHisBooks(Set<Book> bookSet) {
        return bookDAO.addAuthorWithAllHisBooks(bookSet);
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
    public int getTransactionType() {
        return bookDAO.getTransactionType();
    }

    @Override
    public void setTransactionType(int transactionType) {
        bookDAO.setTransactionType(transactionType);
    }

    @Override
    public boolean closeConnection() {
        return bookDAO.closeConnection();
    }

    @Override
    public String booksToXml() {
        AbstractXML al= fm.getAbstractXML();
        List<Book> bookList=bookDAO.getAllABooks();
        Books books = new Books(bookList);
        return  al.marshal(books);

    }

    @Override
    public Set<Book> checkBooks(Books books) {
        return bookDAO.checkBooks(books);
    }

    public boolean writeXmlFile(String xml){
        return bookDAO.writeXmlFile(xml);
    }

    @Override
    public Object readXmlFile(String path) {
        AbstractXML   al=  fm.getAbstractXML();
       return   al.readXmlFile(path);
    }

    @Override
    public boolean validate(String xsdPath, String xmlPath) {
        AbstractXML al= fm.getAbstractXML();
        return al.validate(xsdPath,xmlPath);
    }

    @Override
    public String moneyCourse(String path) {
        return bookDAO.moneyCourse(path);
    }
}
