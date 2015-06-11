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
import org.hibernate.Transaction;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public class EventIpl extends EventDao {

    private Session session = null;

    public EventIpl() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<Event> getEvents() {

        Transaction transaction = null;
        List<Event> list = null;
        try {

            transaction = session.beginTransaction();
            list = session.createQuery("from Event order by created_date desc").list();
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Event> getEvents(int idUser) {

        Transaction transaction = null;
        List<Event> list = null;
        try {
            transaction = session.beginTransaction();
            String query = "from Event as ev where ev.account.idAccount =" + idUser;
            list = session.createQuery(query).list();
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Event getEvent(int id) {

        Transaction transaction = null;
        Event event = null;
        try {

            transaction = session.beginTransaction();
            event = (Event) session.get(Event.class, id);
            transaction.commit();

        } catch (HibernateException e) {

            e.printStackTrace();
        }
        return event;

    }

    @Override
    public Integer insertEvent(Event event) {

        Transaction transaction = null;
        Integer idEvent = null;
        try {
            transaction = session.beginTransaction();
            idEvent = (Integer) session.save(event);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return idEvent;
    }

    @Override
    public boolean deleteEvent(Event event) {

        Transaction transaction = null;
        boolean result = false;

        try {

            transaction = session.beginTransaction();
            session.delete(event);
            transaction.commit();
            result = true;

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public boolean updateEvent(Event event) {

        Transaction transaction = null;
        boolean result = false;

        try {

            transaction = session.beginTransaction();
            session.update(event);
            transaction.commit();
            result = true;

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return result;
    }

}
