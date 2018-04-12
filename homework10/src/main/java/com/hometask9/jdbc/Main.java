package com.hometask9.jdbc;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.config.DBConfigBuilder;
import com.hometask9.jdbc.controller.Controller;
import com.hometask9.jdbc.dao.BookDAOImpl;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by kleba on 10.04.2018.
 */
public class Main {

    public static void main(String[] args) {
        DBConfigBuilder dbConfigBuilder = new DBConfigBuilder();
        DB dbConfig = dbConfigBuilder.setConnectionString("jdbc:mysql://localhost:3306/books")
                .setDriverName("com.mysql.jdbc.Driver")
                .setLogin("root")
                .setPassword("pass")
                .build();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc= new Scanner(System.in);
        Controller controller = new Controller();
        controller.connect(dbConfig);
        int choice = 0;
        do {
        System.out.println("Menu");
        System.out.println("1.Get Set of authors");
        System.out.println("2.Get list of books");
        System.out.println("3.Add author");
        System.out.println("4.Add book");
        System.out.println("5.Update book name By book Id");
        System.out.println("6.Delete author with his books by Id");
        System.out.println("7.Search books by authors name and surname");
        System.out.println("8.Exit");
            try {
                choice = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                choice = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (choice){
                case 1:
                    System.out.println(controller.getAllAuthors());
                    break;
                case 2:
                    System.out.println(controller.getAllABooks());
                    break;
                case 3:
                    System.out.println("Set name");
                    Author author = new Author();
                    author.setName(sc.nextLine());
                    System.out.println("Set surname");
                    author.setSurname(sc.nextLine());
                    System.out.println("Set birthday date(2015-03-31)");
                    String str = sc.nextLine();
                    java.sql.Date date = java.sql.Date.valueOf(str);
                    author.setBirthday(date);
                    controller.persist(author);
                    break;
                case 4:
                    System.out.println("Set name");
                    String name = sc.nextLine();
                    System.out.println("Set number of pages");
                    int numberofPages = sc.nextInt();
                    System.out.println("Set author's id");
                    int id = sc.nextInt();
                    Book book = new Book(name, numberofPages, id);
                    controller.persist(book);
                    break;
                case 5:
                    System.out.println("Set new name");
                    String booksName = sc.nextLine();
                    System.out.println("Set book id");
                    int booksid = sc.nextInt();
                     controller.updateBookNameByBookId(booksName,booksid);
                    break;
                case 6:
                    System.out.println("Set book id");
                    int booksidfordel = sc.nextInt();
                    controller.deleteAuthorWithHisBooksById(booksidfordel);
                    break;
                case 7:
                    System.out.println("Set authors name and surname");
                    String authorName = sc.nextLine();
                    String authorSurname = sc.nextLine();
                    System.out.println(controller.searchBooksByAuthor(authorName, authorSurname));
                    break;
                case 8:
                    controller.closeConnection();
                    break;
                default:
                    System.out.println("Wrong number");
            }
        }
        while (choice != 8);
    }
}
