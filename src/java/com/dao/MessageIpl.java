package com.dao;

import com.model.Message;
import com.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 * @author Phu Ba Duong ameniorer
 */
public class MessageIpl extends MessageDao {

    private Session session = null;
    private SessionFactory sessionFactory = null;

    public MessageIpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Message> getMessages(int idUser) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Message> list = null;
        try {
            transaction = session.beginTransaction();
            String query = "from Message as m where m.accountByAccountId1.idAccount=" + idUser;
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
    public List<Message> getMessagesByIdUsers(int idUser1, int idUser2) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Message> list = null;
        try {
            transaction = session.beginTransaction();
            String query = "from Message as m where m.accountByAccountId1.idAccount=" + idUser1 + "and m.accountByAccountId2.idAccount=" + idUser2;
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
    public Integer insertMessage(Message message) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer idMesg = null;
        try {
            transaction = session.beginTransaction();
            idMesg = (Integer) session.save(message);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return idMesg;
        }
    }

    @Override
    public boolean deleteMessage(Message message) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.delete(message);
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
    public boolean updateMessage(Message message) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.update(message);
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
