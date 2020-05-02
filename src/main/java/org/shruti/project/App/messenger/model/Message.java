package org.shruti.project.App.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@XmlRootElement
public class Message {
    private long id;
    private String message;
    private Date created;
    private String author;
    private Map<Long,Comment> comments = new HashMap<>();
    private List<Link> links = new ArrayList<>();
    public Message(){

    }

    public Message(long id,String message,String author){
          this.id = id;
          this.message = message;
          this.created = new Date();
          this.author = author;
          this.created = new Date();
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    public void addLink(String url , String rel){
        Link link1 = new Link();
        link1.setLink(url);
        link1.setRel(rel);
        links.add(link1);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
     @XmlTransient
    public Map<Long,Comment> getComments(){
        return comments;
    }
    public void setComments(Map<Long,Comment> comments){
           this.comments = comments;
    }

}
