/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Comment;
import com.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 * @author Duong ameliorer
 */
public class CommentIpl extends CommentDao {

    private Session session = null;
    private SessionFactory sessionFactory = null;

    public CommentIpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Comment> getComments() {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Comment> list = null;
        try {
            transaction.begin();
            list = session.createQuery("from Comment").list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return list;
        }
    }

    @Override
    public Comment getCommentById(int id) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Comment comment = null;
        try {
            transaction = session.beginTransaction();
            comment = (Comment) session.get(Comment.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return comment;
        }
    }

    @Override
    public List<Comment> getCommentsByEvent(int idEvent) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Comment> list = null;
        try {
            transaction = session.beginTransaction();
            String query = "from Comment as c where c.event.idEvent =" + idEvent;
            list = session.createQuery(query).list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return list;
        }
    }

    @Override
    public Integer insertComment(Comment comment) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer commentId = null;
        try {
            transaction = session.beginTransaction();
            commentId = (Integer) session.save(comment);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return commentId;
        }
    }

    @Override
    public boolean deleteComment(Comment comment) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.delete(comment);
            transaction.commit();
            result = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return result;
        }
    }

    @Override
    public boolean updateComment(Comment comment) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.update(comment);
            transaction.commit();
            result = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return result;
        }
    }
}
