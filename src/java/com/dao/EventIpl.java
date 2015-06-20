/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Event;
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
public class EventIpl extends EventDao {

    private Session session = null;
    private SessionFactory sessionFactory = null;

    public EventIpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Event> getEvents() {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Event> list = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery("from Event order by created_date desc").list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return list;
        }
    }

    @Override
    public List<Event> getEvents(int idUser) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Event> list = null;
        try {
            transaction = session.beginTransaction();
            String query = "from Event as ev where ev.account.idAccount =" + idUser;
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
    public Event getEvent(int id) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Event event = null;
        try {
            transaction = session.beginTransaction();
            event = (Event) session.get(Event.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return event;
        }
    }

    @Override
    public Integer insertEvent(Event event) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer idEvent = null;
        try {
            transaction = session.beginTransaction();
            idEvent = (Integer) session.save(event);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return idEvent;
        }
    }

    @Override
    public boolean deleteEvent(Event event) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.delete(event);
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
    public boolean updateEvent(Event event) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.update(event);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return result;
        }
    }
}
