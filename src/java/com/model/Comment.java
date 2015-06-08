package com.model;
// Generated Jun 8, 2015 4:53:33 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Comment generated by hbm2java
 */
public class Comment  implements java.io.Serializable {


     private int idComment;
     private Account account;
     private Event event;
     private String content;
     private Date createdDate;

    public Comment() {
    }

    public Comment(int idComment, Account account, Event event, String content, Date createdDate) {
       this.idComment = idComment;
       this.account = account;
       this.event = event;
       this.content = content;
       this.createdDate = createdDate;
    }
   
    public int getIdComment() {
        return this.idComment;
    }
    
    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }
    public Account getAccount() {
        return this.account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    public Event getEvent() {
        return this.event;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }




}


