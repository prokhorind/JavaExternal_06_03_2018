package com.hometask9.jdbc.util.xmlfactory;

import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.util.Books;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Created by kleba on 20.04.2018.
 */
public class StaxXml implements AbstractXML {
    @Override
    public AbstractXML getXMLBuilder() {
        return this;
    }

    @Override
    public String marshal(Books book) {
        return null;
    }

    @Override
    public Object readXmlFile(String path) {
        Books empList = null;
        Book currEmp = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =null;
        try {
            reader = factory.createXMLStreamReader(new InputStreamReader(new FileInputStream(new File(path))));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while(reader.hasNext()){
                int event = reader.next();

                switch(event){
                    case XMLStreamConstants.START_ELEMENT:
                        if ("book".equals(reader.getLocalName())){
                            currEmp = new Book();
                        }
                        if("books".equals(reader.getLocalName())){
                            empList = new Books();
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch(reader.getLocalName()){
                            case "book":
                                empList.getBookList().add(currEmp);
                                break;
                            case "name":
                                currEmp.setName(tagContent);
                                break;
                            case "id":
                                currEmp.setId(Long.parseLong(tagContent));
                                break;
                            case "numberOfPages":
                                currEmp.setNumberOfPages(Integer.parseInt(tagContent));
                            case "authorId":
                                currEmp.setAuthorId(Long.parseLong(tagContent));
                                break;
                        }
                        break;

                    case XMLStreamConstants.START_DOCUMENT:
                        empList = new Books();
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return empList;
    }

    @Override
    public boolean validate(String schema, String file) {
        return false;
    }
}
