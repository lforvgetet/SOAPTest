package com.fis.www.soaptest;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by f103082 on 2015/5/5.
 */
public class SaxXMLHandler extends DefaultHandler {
    private List<Books> books;
    private Books book;
    private Boolean currentElement= false;
    private String currentValue="";
    public List<Books> getBooks(){return books;}
    @Override
    public void startDocument() throws SAXException{books = new ArrayList<>();}

    @Override
    public void startElement(String uri,String localName, String qName, Attributes attributes)throws SAXException{
        System.out.println("startElement Start:" +localName);
        currentElement= true;
        currentValue="";
        if(localName.equals("book")){
            book=new Books();
            book.setIsbn(attributes.getValue("isbn"));
            System.out.println("ISBN:"+attributes.getValue("isbn"));
        }
        System.out.println("StartElement End:"+ localName);

    }
    @Override
    public void endElement(String uri,String localName, String qName){
        System.out.println("endElemnet Start:"+localName);
        currentElement= false;
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
        if (localName.equals("book")){
            books.add(book);
        }
        else if (localName.equals("title")){
            book.setTitle(currentValue);
        }
        else if (localName.equals("author")){

            book.setAuthor(currentValue);
        }
        else if (localName.equals("publisher")){
            book.setPublisher(currentValue);
        }
        else if (localName.equals("publisherdate")){
            try{
                book.setPublichdate(sdf.parse(currentValue));

            }catch(Exception ex){
                book.setPublichdate(null);

            }

        }
        System.out.println("endElement End:"+localName);
    }
@Override
    public void characters(char[] ch, int start, int length) throws SAXException{
    String tempString= new String(ch,start,length);
    System.out.println("Char Start:"+tempString+"|");
    if (currentElement){
        currentValue= currentValue+tempString;
    }
    System.out.println("char end.");

}


}
