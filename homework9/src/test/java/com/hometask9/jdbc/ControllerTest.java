package com.hometask9.jdbc;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.config.DBConfigBuilder;

import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import com.mysql.jdbc.Statement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by kleba on 10.04.2018.
 */
public class ControllerTest {
    Controller controller;
    DB dbConfig;
    Connection c;
    @Before
    public void setUp() throws Exception {
        DBConfigBuilder dbConfigBuilder = new DBConfigBuilder();
        dbConfig = dbConfigBuilder.setConnectionString("jdbc:mysql://localhost:3306/books")
                .setDriverName("com.mysql.jdbc.Driver")
                .setLogin("root")
                .setPassword("pass")
                .build();
                controller= new Controller();
                controller.connect(dbConfig);
    }

    @After
    public void tearDown() throws Exception {
        controller=null;
        dbConfig=null;
    }

    @Test
    public void connect() throws Exception {
        String schema="books";
        String mySqlSchema=c.getCatalog();
        assertEquals(schema,mySqlSchema);
    }

    @Test
    public void persist()  throws Exception {
        Author author = new Author();
        author.setName("1");
        author.setSurname("2");
        java.sql.Date date = java.sql.Date.valueOf("2015-03-31");
        author.setBirthday(date);
        boolean status= controller.persist(author);
        assertTrue(status);
    }

    @Test
    public void searchBooksByAuthor() throws Exception {
        int size=2;
        List<Book> bookList= controller.searchBooksByAuthor("Al","Kosh");
        assertEquals(size,bookList.size());
    }

    @Test
    public void deleteAuthorWithHisBooksById() throws Exception {
        int booksidfordel = 1;
        boolean status=controller.deleteAuthorWithHisBooksById(booksidfordel);
        assertTrue(status);
    }

    @Test
    public void updateBookNameByBookId() throws Exception {
        String booksName ="Faculty of Fire";
        long booksid=5;
        boolean status=controller.updateBookNameByBookId(booksName,booksid);
        assertTrue(status);
    }

    @Test
    public void getAllAuthors() throws Exception {
        int authors=3;
        int dbAuthors= controller.getAllAuthors().size();
        assertEquals(authors,dbAuthors);
    }

    @Test
    public void getAllABooks() throws Exception {
        int books=3;
        int dbBooks= controller.getAllABooks().size();
        assertEquals(books,dbBooks);
    }

}