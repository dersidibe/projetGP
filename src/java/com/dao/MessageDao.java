package com.dao;

import com.model.Message;
import java.util.List;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public abstract class MessageDao {
    
    public abstract List<Message> getMessages(int idUser);
    
    public abstract List<Message> getMessagesByIdUsers(int idUser1, int idUser2);

    public abstract Integer insertMessage(Message message);

    public abstract boolean deleteMessage(Message message);

    public abstract boolean updateMessage(Message message);    
}
