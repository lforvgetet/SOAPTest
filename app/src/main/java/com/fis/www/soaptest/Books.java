package com.fis.www.soaptest;

import java.util.Date;

/**
 * Created by f103082 on 2015/5/5.
 */
public class Books {
    private String isbn="";
    private String title="";
    private String author="";
    private String publisher="";
    private Date publichdate=new Date();

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublichdate() {
        return publichdate;
    }

    public void setPublichdate(Date publichdate) {
        this.publichdate = publichdate;
    }
}
