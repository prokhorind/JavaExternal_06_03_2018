package com.hometask9.jdbc.util;

import com.hometask9.jdbc.entity.Book;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kleba on 17.04.2018.
 */
@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
public class Books {

    @XmlElement(name = "book")
    private List<Book> bookList;

    public Books(){
        bookList = new ArrayList<>();
    };

    public Books(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


}
