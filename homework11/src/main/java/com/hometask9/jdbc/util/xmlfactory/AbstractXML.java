package com.hometask9.jdbc.util.xmlfactory;

import com.hometask9.jdbc.util.Books;

/**
 * Created by kleba on 19.04.2018.
 */
public interface AbstractXML {
    AbstractXML getXMLBuilder();

    String marshal(Books book);

    Object readXmlFile(String path);

    boolean validate(String schema, String file);
}
