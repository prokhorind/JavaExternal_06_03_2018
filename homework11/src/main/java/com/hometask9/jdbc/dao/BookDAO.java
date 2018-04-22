package com.hometask9.jdbc.dao;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.util.Books;
import com.hometask9.jdbc.util.xmlfactory.FactoryMethod;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

/**
 * Created by kleba on 12.04.2018.
 */
public interface BookDAO {

    Connection connect(DB db);
    boolean persist(Object o);
    List<Book> searchBooksByAuthor(String name, String surname);
    boolean deleteAuthorWithHisBooksById(long authorID);
    boolean updateBookNameByBookId(String newName,long bookId);
    boolean addAuthorWithAllHisBooks(Set<Book> bookSet);
    Set<Author> getAllAuthors();
    List<Book> getAllABooks();
    Connection getConnection();
    int getTransactionType();
    void setTransactionType(int transactionType);
    Set<Book> checkBooks(Books books);
    boolean writeXmlFile(String xml);
    boolean closeConnection();
    String moneyCourse(String path);
}
