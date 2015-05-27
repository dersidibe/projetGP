/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Event;
import java.util.List;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public abstract class EventDao {
  
    public abstract List<Event> getEvents();
    
    public abstract List<Event> getEvents(int idUser);
    
    public abstract Event getEvent(int id);
    
    public abstract Integer insertEvent(Event event);

    public abstract boolean deleteEvent(Event event);

    public abstract boolean updateEvent(Event event);        
    
}
