package com.hometask9.jdbc;

import com.hometask9.jdbc.entity.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kleba on 16.04.2018.
 */
public class AuthorsListener implements Runnable {
    Connection con;
    public AuthorsListener(Connection con){
        this.con=con;
    }
    Set<Author> getAllAuthors(){
        Set<Author> authorSet = new HashSet<>();
        String sql="Select * From Author";
        ResultSet rs;
        try {
            con.setTransactionIsolation(8);
            Statement statement = con.createStatement();
            rs=statement.executeQuery(sql);
            while(rs.next()){
                Author a = new Author();
                a.setId(rs.getLong(1));
                a.setName(rs.getString(2));
                a.setSurname(rs.getString(3));
                a.setBirthday(rs.getDate(4));
                authorSet.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return authorSet;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(getAllAuthors());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}