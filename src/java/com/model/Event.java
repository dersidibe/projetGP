package com.model;
// Generated Jun 20, 2015 9:44:15 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Event generated by hbm2java
 */
public class Event  implements java.io.Serializable {


     private int idEvent;
     private Account account;
     private String title;
     private String content;
     private short mode;
     private short status;
     private Date startDate;
     private Date endDate;
     private Date createdDate;
     private String modifier;
     private Date modifiedDate;
     private String image;
     private Set comments = new HashSet(0);
     private Set comments_1 = new HashSet(0);

    public Event() {
    }

	
    public Event(int idEvent, Account account, String title, String content, short mode, short status, Date startDate, Date endDate, Date createdDate) {
        this.idEvent = idEvent;
        this.account = account;
        this.title = title;
        this.content = content;
        this.mode = mode;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdDate = createdDate;
    }
    public Event(int idEvent, Account account, String title, String content, short mode, short status, Date startDate, Date endDate, Date createdDate, String modifier, Date modifiedDate, String image, Set comments, Set comments_1) {
       this.idEvent = idEvent;
       this.account = account;
       this.title = title;
       this.content = content;
       this.mode = mode;
       this.status = status;
       this.startDate = startDate;
       this.endDate = endDate;
       this.createdDate = createdDate;
       this.modifier = modifier;
       this.modifiedDate = modifiedDate;
       this.image = image;
       this.comments = comments;
       this.comments_1 = comments_1;
    }
   
    public int getIdEvent() {
        return this.idEvent;
    }
    
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    public Account getAccount() {
        return this.account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public short getMode() {
        return this.mode;
    }
    
    public void setMode(short mode) {
        this.mode = mode;
    }
    public short getStatus() {
        return this.status;
    }
    
    public void setStatus(short status) {
        this.status = status;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getModifier() {
        return this.modifier;
    }
    
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    public Date getModifiedDate() {
        return this.modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Set getComments() {
        return this.comments;
    }
    
    public void setComments(Set comments) {
        this.comments = comments;
    }
    public Set getComments_1() {
        return this.comments_1;
    }
    
    public void setComments_1(Set comments_1) {
        this.comments_1 = comments_1;
    }




}


