package com.hometask9.jdbc.util.xmlfactory;

/**
 * Created by kleba on 20.04.2018.
 */
public class FactoryMethod {
    private AbstractXML abstractXML;

    public void setAbstractXML(String type) {
        if(type.equalsIgnoreCase("jaxb")){
            abstractXML=new JaxbXml();
        }else if(type.equalsIgnoreCase("sax")){
            abstractXML=new SaxXml();
        }else if(type.equalsIgnoreCase("Stax")){
            abstractXML=new StaxXml();
        }
        else{
            System.out.println("type not supported");
            return;
        }
    }

    public AbstractXML getAbstractXML() {
        return abstractXML;
    }
}
