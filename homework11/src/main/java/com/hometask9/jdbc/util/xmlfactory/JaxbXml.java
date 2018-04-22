package com.hometask9.jdbc.util.xmlfactory;

import com.hometask9.jdbc.entity.Author;
import com.hometask9.jdbc.entity.Book;
import com.hometask9.jdbc.util.Books;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by kleba on 19.04.2018.
 */
public class JaxbXml implements AbstractXML {

    private JAXBContext jaxbContext;

    public JaxbXml(){
        try {
            jaxbContext= JAXBContext.newInstance(Books.class, Author.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    @Override
    public AbstractXML getXMLBuilder() {
        return this;
    }
    public String marshal(Books book){
        StringWriter sw = new StringWriter();
        try {
            Marshaller marshaller =jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(book, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    @Override
    public Object readXmlFile(String path) {
        Unmarshaller jaxbUnmarshaller=null;
        Books books=null;
        try {
             jaxbUnmarshaller= jaxbContext.createUnmarshaller();
             books = (Books) jaxbUnmarshaller.unmarshal(new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public boolean validate(String schemaPath, String filePath) {
        File schemaFile = new File(schemaPath);
        Source xmlFile = new StreamSource(new File(filePath));
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            ErrorHandler sh = new DefaultHandler();
            validator.setErrorHandler(sh);
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
            return true;
        } catch (SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
            return false;
        } catch (IOException e) {
            return false;
        }

    }
}
