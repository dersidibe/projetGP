package com.model;
// Generated Jun 21, 2015 3:59:53 PM by Hibernate Tools 4.3.1



/**
 * MessageId generated by hbm2java
 */
public class MessageId  implements java.io.Serializable {


     private int idMessage;
     private int accountId1;
     private int accountId2;

    public MessageId() {
    }

    public MessageId(int idMessage, int accountId1, int accountId2) {
       this.idMessage = idMessage;
       this.accountId1 = accountId1;
       this.accountId2 = accountId2;
    }
   
    public int getIdMessage() {
        return this.idMessage;
    }
    
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }
    public int getAccountId1() {
        return this.accountId1;
    }
    
    public void setAccountId1(int accountId1) {
        this.accountId1 = accountId1;
    }
    public int getAccountId2() {
        return this.accountId2;
    }
    
    public void setAccountId2(int accountId2) {
        this.accountId2 = accountId2;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MessageId) ) return false;
		 MessageId castOther = ( MessageId ) other; 
         
		 return (this.getIdMessage()==castOther.getIdMessage())
 && (this.getAccountId1()==castOther.getAccountId1())
 && (this.getAccountId2()==castOther.getAccountId2());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdMessage();
         result = 37 * result + this.getAccountId1();
         result = 37 * result + this.getAccountId2();
         return result;
   }   


}


