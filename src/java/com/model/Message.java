package com.model;
// Generated Jun 21, 2015 3:59:53 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Message generated by hbm2java
 */
public class Message  implements java.io.Serializable {


     private MessageId id;
     private Account accountByAccountId2;
     private Account accountByAccountId1;
     private String content;
     private Date createdDate;
     private Date modifiedDate;

    public Message() {
    }

	
    public Message(MessageId id, Account accountByAccountId2, Account accountByAccountId1, String content, Date createdDate) {
        this.id = id;
        this.accountByAccountId2 = accountByAccountId2;
        this.accountByAccountId1 = accountByAccountId1;
        this.content = content;
        this.createdDate = createdDate;
    }
    public Message(MessageId id, Account accountByAccountId2, Account accountByAccountId1, String content, Date createdDate, Date modifiedDate) {
       this.id = id;
       this.accountByAccountId2 = accountByAccountId2;
       this.accountByAccountId1 = accountByAccountId1;
       this.content = content;
       this.createdDate = createdDate;
       this.modifiedDate = modifiedDate;
    }
   
    public MessageId getId() {
        return this.id;
    }
    
    public void setId(MessageId id) {
        this.id = id;
    }
    public Account getAccountByAccountId2() {
        return this.accountByAccountId2;
    }
    
    public void setAccountByAccountId2(Account accountByAccountId2) {
        this.accountByAccountId2 = accountByAccountId2;
    }
    public Account getAccountByAccountId1() {
        return this.accountByAccountId1;
    }
    
    public void setAccountByAccountId1(Account accountByAccountId1) {
        this.accountByAccountId1 = accountByAccountId1;
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
    public Date getModifiedDate() {
        return this.modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }




}


