package com.model;
// Generated Jun 21, 2015 3:59:53 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 * Account generated by hbm2java
 */
@Entity(name = "account")
public class Account implements java.io.Serializable {

    @Id
    @GenericGenerator(name = "account_id_seq", strategy = "sequence", parameters = {
        @org.hibernate.annotations.Parameter(name = "account_id_seq", value = "sequence"),
        @org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),})
    @GeneratedValue(generator = "account_id_seq", strategy = GenerationType.SEQUENCE)
     private int idAccount;
     private String firstName;
     private String lastName;
     private String username;
     private String password;
     private String image;
     private short type;
     private Integer promotion;
     private short status;
     private String email;
     private Date birthday;
     private String nationality;
     private Character sex;
     private String occupation;
     private Date createdDate;
     private Date modifiedDate;
     private Date jobStartTime;
     private Date jobEndTime;
     private Set events = new HashSet(0);
     private Set messagesForAccountId2 = new HashSet(0);
     private Set events_1 = new HashSet(0);
     private Set messagesForAccountId1 = new HashSet(0);
     private Set messagesForAccountId1_1 = new HashSet(0);
     private Set comments = new HashSet(0);
     private Set messagesForAccountId2_1 = new HashSet(0);
     private Set comments_1 = new HashSet(0);
     private Set offers = new HashSet(0);
     private Set offers_1 = new HashSet(0);

    public Account() {
    }

	
    public Account(int idAccount, String firstName, String lastName, String username, String password, short type, short status, String email, Date createdDate) {
        this.idAccount = idAccount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.type = type;
        this.status = status;
        this.email = email;
        this.createdDate = createdDate;
    }
    public Account(int idAccount, String firstName, String lastName, String username, String password, String image, short type, Integer promotion, short status, String email, Date birthday, String nationality, Character sex, String occupation, Date createdDate, Date modifiedDate, Date jobStartTime, Date jobEndTime, Set events, Set messagesForAccountId2, Set events_1, Set messagesForAccountId1, Set messagesForAccountId1_1, Set comments, Set messagesForAccountId2_1, Set comments_1, Set offers, Set offers_1) {
       this.idAccount = idAccount;
       this.firstName = firstName;
       this.lastName = lastName;
       this.username = username;
       this.password = password;
       this.image = image;
       this.type = type;
       this.promotion = promotion;
       this.status = status;
       this.email = email;
       this.birthday = birthday;
       this.nationality = nationality;
       this.sex = sex;
       this.occupation = occupation;
       this.createdDate = createdDate;
       this.modifiedDate = modifiedDate;
       this.jobStartTime = jobStartTime;
       this.jobEndTime = jobEndTime;
       this.events = events;
       this.messagesForAccountId2 = messagesForAccountId2;
       this.events_1 = events_1;
       this.messagesForAccountId1 = messagesForAccountId1;
       this.messagesForAccountId1_1 = messagesForAccountId1_1;
       this.comments = comments;
       this.messagesForAccountId2_1 = messagesForAccountId2_1;
       this.comments_1 = comments_1;
       this.offers = offers;
       this.offers_1 = offers_1;
    }
   
    public int getIdAccount() {
        return this.idAccount;
    }
    
    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public short getType() {
        return this.type;
    }
    
    public void setType(short type) {
        this.type = type;
    }
    public Integer getPromotion() {
        return this.promotion;
    }
    
    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }
    public short getStatus() {
        return this.status;
    }
    
    public void setStatus(short status) {
        this.status = status;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getNationality() {
        return this.nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public Character getSex() {
        return this.sex;
    }
    
    public void setSex(Character sex) {
        this.sex = sex;
    }
    public String getOccupation() {
        return this.occupation;
    }
    
    public void setOccupation(String occupation) {
        this.occupation = occupation;
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
    public Date getJobStartTime() {
        return this.jobStartTime;
    }
    
    public void setJobStartTime(Date jobStartTime) {
        this.jobStartTime = jobStartTime;
    }
    public Date getJobEndTime() {
        return this.jobEndTime;
    }
    
    public void setJobEndTime(Date jobEndTime) {
        this.jobEndTime = jobEndTime;
    }
    public Set getEvents() {
        return this.events;
    }
    
    public void setEvents(Set events) {
        this.events = events;
    }
    public Set getMessagesForAccountId2() {
        return this.messagesForAccountId2;
    }
    
    public void setMessagesForAccountId2(Set messagesForAccountId2) {
        this.messagesForAccountId2 = messagesForAccountId2;
    }
    public Set getEvents_1() {
        return this.events_1;
    }
    
    public void setEvents_1(Set events_1) {
        this.events_1 = events_1;
    }
    public Set getMessagesForAccountId1() {
        return this.messagesForAccountId1;
    }
    
    public void setMessagesForAccountId1(Set messagesForAccountId1) {
        this.messagesForAccountId1 = messagesForAccountId1;
    }
    public Set getMessagesForAccountId1_1() {
        return this.messagesForAccountId1_1;
    }
    
    public void setMessagesForAccountId1_1(Set messagesForAccountId1_1) {
        this.messagesForAccountId1_1 = messagesForAccountId1_1;
    }
    public Set getComments() {
        return this.comments;
    }
    
    public void setComments(Set comments) {
        this.comments = comments;
    }
    public Set getMessagesForAccountId2_1() {
        return this.messagesForAccountId2_1;
    }
    
    public void setMessagesForAccountId2_1(Set messagesForAccountId2_1) {
        this.messagesForAccountId2_1 = messagesForAccountId2_1;
    }
    public Set getComments_1() {
        return this.comments_1;
    }
    
    public void setComments_1(Set comments_1) {
        this.comments_1 = comments_1;
    }
    public Set getOffers() {
        return this.offers;
    }
    
    public void setOffers(Set offers) {
        this.offers = offers;
    }
    public Set getOffers_1() {
        return this.offers_1;
    }
    
    public void setOffers_1(Set offers_1) {
        this.offers_1 = offers_1;
    }




}


