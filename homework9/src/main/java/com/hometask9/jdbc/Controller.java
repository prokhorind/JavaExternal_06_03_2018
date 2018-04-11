package com.hometask9.jdbc;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kleba on 10.04.2018.
 */
public class Controller {

    private Connection connection;

    public Connection connect(DB db) {
        try {
            Class.forName(db.getDriverName());
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return null;
        }
        try {
            connection = DriverManager.getConnection(db.getConnectionString(), db.getLogin(), db.getPassword());
        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
            return null;
        }
        return connection;
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
                
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                System.out.println(response);
            }
           
        }else if(o instanceof Book){
            Book book= (Book) o;
            PreparedStatement pr ;
            int response = 0;
            try {
                pr = connection.prepareStatement("INSERT INTO Book(Title,NumberOfPages,AuthorID) values(?,?,?)");
                pr.setString(1,book.getName());
                pr.setInt(2,book.getNumberOfPages());
                pr.setLong(3,book.getAuthorId());
                response=pr.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                System.out.println(response);
            }
        }else{
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
            while(rs.next()){
                Book b= new Book();
                b.setId(rs.getLong(1));
                b.setName(rs.getString(2));
                b.setNumberOfPages(rs.getInt(3));
                b.setAuthorId(rs.getLong(4));
                books.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
        } catch (SQLException e) {
            e.printStackTrace();
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

        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }finally {
            System.out.println(response);
        }

        return true;
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

        } catch (SQLException e) {
            e.printStackTrace();
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

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return  books;
    }

    public Connection getConnection() {
        return connection;
    }
}
