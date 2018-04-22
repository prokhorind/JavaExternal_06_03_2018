package com.hometask9.jdbc.util.xmlfactory;

import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.util.Books;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

/**
 * Created by kleba on 19.04.2018.
 */
public class SaxXml implements AbstractXML {

    @Override
    public AbstractXML getXMLBuilder() {
        return this;
    }

    @Override
    public String marshal(Books book) {
        String path = null;
        XMLStreamWriter out = null;
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(path));
            out = XMLOutputFactory.newInstance().createXMLStreamWriter(
                    new OutputStreamWriter(outputStream, "utf-8"));
            out.writeStartDocument();
            out.writeStartElement("doc");

            out.writeStartElement("title");
            out.writeCharacters("Document Title");
            out.writeEndElement();

            out.writeEndElement();
            out.writeEndDocument();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        XMLStreamWriter outXml = null;
        try {
            outXml = XMLOutputFactory.newInstance().createXMLStreamWriter(
                    new OutputStreamWriter(outputStream, "utf-8"));
            outXml.writeStartDocument();
            outXml.writeStartElement("doc");

            outXml.writeStartElement("title");
            outXml.writeCharacters("Document Title");
            outXml.writeEndElement();

            outXml.writeEndElement();
            outXml.writeEndDocument();

            outXml.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return outXml.toString();
    }

    @Override
    public Object readXmlFile(String path) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        MyHandler handler = null;
        Books books = new Books();
        try {
            saxParser = saxParserFactory.newSAXParser();
            handler = new MyHandler();
            saxParser.parse(new File(path), handler);
            books = handler.getBooks();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public boolean validate(String schema, String file) {
        return false;
    }

    public class MyHandler extends DefaultHandler {

        private Books books = new Books();
        private Book book = null;

        public Books getBooks() {
            return books;
        }

        boolean bId = false;
        boolean bName = false;
        boolean bNumberOfPages = false;
        boolean bAuthorId = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("book")) {
                book = new Book();
                if (books == null)
                    books = new Books();
            } else if (qName.equalsIgnoreCase("name")) {

                bName = true;
            } else if (qName.equalsIgnoreCase("id")) {
                bId = true;
            } else if (qName.equalsIgnoreCase("numberOfpages")) {
                bNumberOfPages = true;
            } else if (qName.equalsIgnoreCase("authorId")) {
                bAuthorId = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("book")) {

                books.getBookList().add(book);
            }
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {

            if (bId) {
                book.setId(Long.parseLong(new String(ch, start, length)));
                bId = false;
            } else if (bName) {
                book.setName(new String(ch, start, length));
                bName = false;
            } else if (bAuthorId) {
                book.setAuthorId(Long.parseLong(new String(ch, start, length)));
                bAuthorId = false;
            } else if (bNumberOfPages) {
                book.setNumberOfPages(Integer.parseInt(new String(ch, start, length)));
                bNumberOfPages = false;
            }
        }
    }
}

