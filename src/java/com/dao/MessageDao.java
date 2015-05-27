/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Message;
import java.util.List;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public abstract class MessageDao {
    
    public abstract List<Message> getMessages();
    
    public abstract List<Message> getMessagesByIdUsers(int idUser1, int idUser2);
    
    public abstract Message getMessage(int id);

    public abstract Integer insertMessage(Message message);

    public abstract boolean deleteMessage(Message message);

    public abstract boolean updateMessage(Message message);    
}
