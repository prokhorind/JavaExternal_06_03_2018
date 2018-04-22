package com.hometask9.jdbc;

import com.hometask9.jdbc.config.DB;
import com.hometask9.jdbc.config.DBConfigBuilder;
import com.hometask9.jdbc.controller.Controller;
import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.util.Books;
import com.hometask9.jdbc.util.xmlfactory.FactoryMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
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
        controller.setTransactionType(8);
        int choice = 0;
        Thread thread= new Thread(new AuthorsListener(controller.connect(dbConfig)));
        thread.start();
        FactoryMethod fm = new FactoryMethod();
        fm.setAbstractXML("jaxb");
        controller.setFm(fm);
        String xml=controller.booksToXml();
        Books booksFromXmlFile= (Books) controller.readFromFile("src\\main\\resources\\input.xml");
        System.out.println(booksFromXmlFile.getBookList().toString());
        do {
            System.out.println("Menu");
            System.out.println("1.Get Set of authors");
            System.out.println("2.Get list of books");
            System.out.println("3.Add author");
            System.out.println("4.Add book");
            System.out.println("5.Update book name By book Id");
            System.out.println("6.Delete author with his books by Id");
            System.out.println("7.Search books by authors name and surname");
            System.out.println("8.Add all books with author ");
            System.out.println("9.Insert books from xml file");
            System.out.println("10. Money Course");
            System.out.println("11.Exit");
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
                    Set<Book>bookSet = new HashSet<>();
                    System.out.println("Set authors id");
                    id=sc.nextInt();
                    System.out.println("Set number of books");
                    int count=sc.nextInt();
                    for(int i=0;i<count;i++){
                        sc.nextLine();
                        System.out.println("Set name");
                        name = sc.nextLine();
                        System.out.println("Set number of pages");
                        numberofPages = sc.nextInt();
                        book = new Book(name, numberofPages, id);
                        bookSet.add(book);
                    }
                    controller.addAuthorWithAllHisBooks(bookSet);
                    break;
                case 9:
                    if( controller.validate("src\\main\\resources\\schema.xsd","src\\main\\resources\\input.xml")) {
                        Books books = (Books) controller.readFromFile("src\\main\\resources\\input.xml");
                        Set<Book> bSet= controller.checkBooks(books);
                        for(Book b:bSet){
                            System.out.println("Old name:"+b.getName());
                            System.out.println("Enter new Name");
                            String bn=sc.nextLine();
                            controller.updateBookNameByBookId(bn,b.getId());
                        }
                    }
                    break;
                case 10:
                    System.out.println(controller.moneyCourse("http://resources.finance.ua/ru/public/currency-cash.xml"));
                    break;
                case 11:
                    //thread.interrupt();
                    controller.closeConnection();
                    break;
                default:
                    System.out.println("Wrong number");
            }
        }
        while (choice != 11);
    }
}
