package com.hometask9.jdbc;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.config.DBConfigBuilder;

import com.hometask9.jdbc.dao.BookDAO;
import com.hometask9.jdbc.dao.BookDAOImpl;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by kleba on 10.04.2018.
 */
public class BookDAOTest {
    BookDAO bookDAO;
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
        bookDAO= new BookDAOImpl();
        bookDAO.connect(dbConfig);
    }

    @After
    public void tearDown() throws Exception {
        bookDAO=null;
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
        boolean status= bookDAO.persist(author);
        assertTrue(status);
    }

    @Test
    public void searchBooksByAuthor() throws Exception {
        int size=2;
        List<Book> bookList= bookDAO.searchBooksByAuthor("Al","Kosh");
        assertEquals(size,bookList.size());
    }

    @Test
    public void deleteAuthorWithHisBooksById() throws Exception {
        int booksidfordel = 1;
        boolean status=bookDAO.deleteAuthorWithHisBooksById(booksidfordel);
        assertTrue(status);
    }

    @Test
    public void updateBookNameByBookId() throws Exception {
        String booksName ="Faculty of Fire";
        long booksid=5;
        boolean status=bookDAO.updateBookNameByBookId(booksName,booksid);
        assertTrue(status);
    }

    @Test
    public void getAllAuthors() throws Exception {
        int authors=3;
        int dbAuthors= bookDAO.getAllAuthors().size();
        assertEquals(authors,dbAuthors);
    }

    @Test
    public void getAllABooks() throws Exception {
        int books=3;
        int dbBooks= bookDAO.getAllABooks().size();
        assertEquals(books,dbBooks);
    }

}