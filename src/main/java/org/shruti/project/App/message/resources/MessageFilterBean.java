package org.shruti.project.App.message.resources;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
    private @QueryParam("year") int year;
    private @QueryParam("start")int start;
    private @QueryParam("size")int size;

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getYear() {
        return year;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
