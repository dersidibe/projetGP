/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dao.EventDao;
import com.model.Event;
import com.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public class EventController extends EventDao{

    private Session session =null;
   
    public EventController(){
        
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    @Override
    public List<Event> getEvents() {
        
        Transaction transaction =null;
    }

    @Override
    public List<Event> getEvents(int idUser) {
    }

    @Override
    public Event getEvent(int id) {
    }

    @Override
    public Integer insertEvent(Event event) {
    }

    @Override
    public boolean deleteEvent(Event event) {
    }

    @Override
    public boolean updateEvent(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
