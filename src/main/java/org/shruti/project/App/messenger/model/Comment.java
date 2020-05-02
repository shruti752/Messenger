package org.shruti.project.App.messenger.model;

import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;

public class Comment {
    private long id;
    private String message;
    private String author;
    private Date created;

    public Comment(){

    }

    public Comment(long id,String message,String author){
        this.id = id;
        this.message = message;
        this.author = author;
        this.created = new Date();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
