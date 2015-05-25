package model;
// Generated May 25, 2015 11:24:21 AM by Hibernate Tools 4.3.1



/**
 * CommentId generated by hbm2java
 */
public class CommentId  implements java.io.Serializable {


     private int eventId;
     private int accountId;

    public CommentId() {
    }

    public CommentId(int eventId, int accountId) {
       this.eventId = eventId;
       this.accountId = accountId;
    }
   
    public int getEventId() {
        return this.eventId;
    }
    
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    public int getAccountId() {
        return this.accountId;
    }
    
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CommentId) ) return false;
		 CommentId castOther = ( CommentId ) other; 
         
		 return (this.getEventId()==castOther.getEventId())
 && (this.getAccountId()==castOther.getAccountId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getEventId();
         result = 37 * result + this.getAccountId();
         return result;
   }   


}


