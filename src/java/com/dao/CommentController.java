/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dao.CommentDao;
import com.model.Comment;
import com.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public class CommentController extends CommentDao{
    
    private Session session = null;
    
    public CommentController(){
    
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<Comment> getComments() {
        
        Transaction transaction = null;
        try{
            
            transaction.begin();
            List<Comment> list = session.createQuery("from Comment").list();
            transaction.commit();
            return list;
            
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Comment getCommentById(int id) {
        
        Transaction transaction = null;
        try{
            
            transaction.begin();
            Comment comment = (Comment) session.get(Comment.class, id);
            transaction.commit();
            return comment;
            
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public List<Comment> getCommentsByEvent(int idEvent) {
        Transaction transaction = null;
        try{
            
            transaction.begin();
            String query = "from Comment as c where c.event.idEvent ="+idEvent;
            List<Comment> list = session.createQuery(query).list();
            transaction.commit();
            return list;
            
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public Integer insertComment(Comment comment) {
        
        Transaction transaction = null;
        Integer commentId = null;
        try {
            transaction = session.beginTransaction();
            commentId = (Integer) session.save(comment);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return commentId;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        
        Transaction transaction = null;
        boolean result =  false;
        try {
            transaction = session.beginTransaction();
            session.delete(comment);
            transaction.commit();
            result =  true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateComment(Comment comment) {
       
        Transaction transaction = null;
        boolean result =  false;
        try {
            transaction = session.beginTransaction();
            session.update(comment);
            transaction.commit();
            result = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }


}
