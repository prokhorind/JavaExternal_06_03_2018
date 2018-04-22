package com.hometask9.jdbc.dao;

import com.hometask9.jdbc.config.ConnectionPool;
import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.util.Books;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.*;


/**
 * Created by kleba on 10.04.2018.
 */
public class BookDAOImpl implements BookDAO {
    private Connection connection;
    private  ConnectionPool connectionPool;
    final static Logger rootLogger = LogManager.getLogger(BookDAOImpl.class);


    /*
    * TRANSACTION_NONE- not supported in MySQL
    * TRANSACTION_READ_UNCOMMITTED =1
    * TRANSACTION_READ_COMMITTED=2
    * TRANSACTION_REPEATABLE_READ=4
    * TRANSACTION_SERIALIZABLE=8
    * */
    public void setTransactionType(int transactionType){
        try {
            connection.setTransactionIsolation(transactionType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Book> checkBooks(Books books) {
        Set<Book> repeatedBook= new HashSet<>();
        List <Book> xmlBooks=new ArrayList<>(books.getBookList());
        System.out.println(xmlBooks.toString());
        List<Book> booksList=new ArrayList(getAllABooks());
        Set<Book> bookSet = new HashSet<>();
        for(int i=0;i<xmlBooks.size();i++){
            boolean flag=false;
            for(int j=0;j<booksList.size();j++){
                if((xmlBooks.get(i).getName().equals(booksList.get(j).getName()))&&i!=j){
                    flag=true;
                }
            }
            if(!flag){
                System.out.println(xmlBooks.get(i));
                bookSet.add(xmlBooks.get(i));
            }else {
                repeatedBook.add(xmlBooks.get(i));
            }
        }
        if(bookSet.size()>0) {
            addAuthorWithAllHisBooks(bookSet);
        }
        return repeatedBook;
    }

    public int getTransactionType(){
        try {
            return connection.getTransactionIsolation();
        } catch (SQLException e) {
            e.printStackTrace();
            return -10;
        }
    }
    public Connection connect(DB db) {
        try {
            connectionPool = new ConnectionPool(db,5);
            connection= connectionPool.retrieve();
            connection.setAutoCommit(false);
            rootLogger.info("db connect");
        } catch (SQLException e) {
            rootLogger.error("Incorrect URL");
        }
        return connection;
    }

    @Override
    public boolean writeXmlFile(String xml) {
        String path="src\\main\\resources\\";
        String name="output.xml";
        File file = new File(path,name);
        FileWriter fw=null;
        try {
            fw = new FileWriter(path+name);
            fw.write(xml);
            fw.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean persist(Object o)  {
        if(o instanceof Author){
            Author author= (Author) o;
            PreparedStatement pr ;
            int response = 0;
            try {
                pr = connection.prepareStatement("INSERT INTO Author(Name,Surname,Birthday) values(?,?,?)");
                pr.setString(1,author.getName());
                pr.setString(2,author.getSurname());
                pr.setDate(3,author.getBirthday());
                response=pr.executeUpdate();
                rootLogger.info("Author inserted into DB");
                connection.commit();
            } catch (SQLException e) {
                rootLogger.error("Incorrect Author arguments");
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }finally {
                System.out.println(response);
            }
           
        }else if(o instanceof Book){
            Book book= (Book) o;
            System.out.println(book);
            PreparedStatement pr ;
            int response = 0;
            try {
                pr = connection.prepareStatement("INSERT INTO Book(Title,NumberOfPages,AuthorID) values(?,?,?)");
                pr.setString(1,book.getName());
                pr.setInt(2,book.getNumberOfPages());
                pr.setLong(3,book.getAuthorId());
                response=pr.executeUpdate();
                connection.commit();
                rootLogger.info("Book inserted into DB");

            } catch (SQLException e) {
                rootLogger.error("Incorrect Book arguments");
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }finally {
                System.out.println(response);
            }
        }else{
            rootLogger.error("Unknown object");
            return false;
        }
        return true;
    }

    public List<Book>searchBooksByAuthor(String name,String surname){
        List<Book> books = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement pr  = connection.prepareStatement("Select b.ID,b.title,b.NumberOfPages,b.AuthorID From Book b, Author a WHERE b.AuthorID=a.ID and a.Surname=? AND a.name like ?");
            pr.setString(1,surname);
            pr.setString(2,"%"+name+"%");
            rs=pr.executeQuery();
            connection.commit();
            while(rs.next()){
                Book b= new Book();
                b.setId(rs.getLong(1));
                b.setName(rs.getString(2));
                b.setNumberOfPages(rs.getInt(3));
                b.setAuthorId(rs.getLong(4));
                books.add(b);
            }
        } catch (SQLException e) {
            rootLogger.error("Incorrect arguments");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return null;
        }
        return books;
    }

    public boolean deleteAuthorWithHisBooksById(long authorID){
        PreparedStatement pr ;
        int response=0;
        try {
            pr = connection.prepareStatement("DELETE FROM Author  where ID=?");
            pr.setLong(1,authorID);
            response=pr.executeUpdate();
            connection.commit();
            rootLogger.info("Author with id "+ authorID+" was deleted");
        } catch (SQLException e) {
            rootLogger.error("Incorrect author id");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return  false;
        }finally {
            System.out.println(response);
        }
        return true;
    }
    public boolean updateBookNameByBookId(String newName,long bookId){
        PreparedStatement pr ;
        int response=0;
        try {
            pr = connection.prepareStatement("UPDATE Book set title=? where ID=?");
            pr.setString(1,newName);
            pr.setLong(2,bookId);
            response=pr.executeUpdate();
            rootLogger.info("Book name was updated");

        } catch (SQLException e) {
            rootLogger.error("Incorrect arguments");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return  false;
        }finally {
            System.out.println(response);
        }
        return true;
    }

    @Override
    public boolean addAuthorWithAllHisBooks( Set<Book> bookSet) {
        Savepoint   savepoint=null;
        boolean flag=false;
        try {
            for (Book book : bookSet) {
                savepoint= connection.setSavepoint();
                persist(book);
            }
            flag = true;
        }catch (Exception e){
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            rootLogger.error("Can't add books");
            flag = false;
        } finally {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return  flag;
        }
    }


    public Set<Author> getAllAuthors(){
        Set<Author> author = new HashSet<>();
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            String sql="Select * From Author";
            rs=statement.executeQuery(sql);
            while(rs.next()){
                Author a = new Author();
                a.setId(rs.getLong(1));
                a.setName(rs.getString(2));
                a.setSurname(rs.getString(3));
                a.setBirthday(rs.getDate(4));
                author.add(a);
            }
            rootLogger.info(author.size()+"authors were found");

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            rootLogger.error("Incorrect arguments");
            return null;
        }
        return  author;
    }

    public List<Book> getAllABooks(){
        List<Book> books = new ArrayList<>();
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            String sql="Select * From Book";
            rs=statement.executeQuery(sql);
            while(rs.next()){
                Book b= new Book();
                b.setId(rs.getLong(1));
                b.setName(rs.getString(2));
                b.setNumberOfPages(rs.getInt(3));
                b.setAuthorId(rs.getLong(4));
                books.add(b);
            }
            rootLogger.info(books.size()+"books were found");
        } catch (SQLException e) {
            rootLogger.error("Incorrect arguments");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return null;
        }
        return  books;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean closeConnection(){
        try {
            connectionPool.putback(connection);
            rootLogger.info("Connection closed");
            return true;
        } catch (Exception e) {
            rootLogger.error("Connection wasn't closed");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public String moneyCourse(String path) {
        try (Scanner scanner = new Scanner(new URL(path).openStream(),
                StandardCharsets.UTF_8.toString()))
        {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
