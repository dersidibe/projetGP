/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.EventIpl;
import com.model.Account;
import com.model.Event;
import com.utils.Settings;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Phu Ba Duong
 */
@Controller
@RequestMapping(value = "/event")
public class EventCtr {

    private EventIpl eventIpl;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/create_event_form", method = RequestMethod.GET)
    public String createEventForm(ModelMap mm, HttpSession session) {
        Event event = new Event();
        Account currentAccount = (Account) session.getAttribute("current_account");
        if (currentAccount == null) {
            return "redirect_index";
        }
        mm.put("result", 0);
        mm.addAttribute("event", event);
        return "create_event_form";
    }

    @RequestMapping(value = "/create_event", method = RequestMethod.POST)
    public String createEvent(@ModelAttribute("event") Event event,
            ModelMap mm, HttpSession session, @RequestParam("file") MultipartFile file) throws Exception {
        
        if (!file.isEmpty()) {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            File destination = new File("/home/lion/Documents/Dropbox/Gestion "
                    + "de projet/Projet/Practice/projetGP/web/images/event/" + event.getImage());
            ImageIO.write(src, "jpg", destination);
        }
        
        eventIpl = new EventIpl();
        Account currentAccount = (Account) session.getAttribute("current_account");
        if (currentAccount == null) {
            return "redirect_index";
        }
        event.setAccount(currentAccount);
        event.setCreatedDate(new Date());
        Integer result = eventIpl.insertEvent(event);
        mm.put("result", result);
        return "redirect_index";
    }

    @RequestMapping(value = "/edit_event_form", method = RequestMethod.GET)
    public String editEventForm(@RequestParam("eventId") int eventId, ModelMap mm, 
            HttpSession session) {
        eventIpl = new EventIpl();
        Event current_event = eventIpl.getEvent(eventId);
        mm.put("current_event", current_event);
        session.setAttribute("eventCreatedDate", current_event.getCreatedDate());
        mm.put("eventId", eventId);
        mm.put("result", null);
        return "edit_event_form";
    }

    @RequestMapping(value = "/edit_event", method = RequestMethod.POST)
    public String editEvent(@RequestParam("eventId") int eventId,
            @ModelAttribute("current_event") Event current_event,
            ModelMap mm, HttpSession session, @RequestParam("file") MultipartFile file)
            throws Exception {
        
        if (!file.isEmpty()) {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            File destination = new File("/home/lion/Documents/Dropbox/Gestion "
                    + "de projet/Projet/Practice/projetGP/web/images/event/" 
                    + current_event.getImage());
            ImageIO.write(src, "jpg", destination);
        }
        
        eventIpl = new EventIpl();
        Account currentAccount = (Account) session.getAttribute("current_account");
        Date createdDate = (Date) session.getAttribute("eventCreatedDate");
        current_event.setIdEvent(eventId);
        current_event.setAccount(currentAccount);
        current_event.setCreatedDate(createdDate);
        current_event.setModifier(currentAccount.getUsername());
        current_event.setModifiedDate(new Date());
        boolean result = eventIpl.updateEvent(current_event);
        mm.put("result", result);
        return "redirect_index";
    }
    
    @RequestMapping(value = "/showDetail", method = RequestMethod.GET)
    public String showDetail(@RequestParam("eventId") int eventId,
            ModelMap mm, HttpSession session) {
        eventIpl = new EventIpl();
        List<Event> subEvents = new ArrayList<>();
        List<Event> events = eventIpl.getEvents();
        if (events != null) {
            subEvents = events.subList(0, Math.min(
                    Settings.NUMBER_EVENTS_AVAIABLE, events.size()));
            for (int i = 0; i < subEvents.size(); i++) {
                if(subEvents.get(i).getIdEvent() != eventId)
                    subEvents.get(i).setContent(subEvents.get(i).getContent().substring(0,
                            Math.min(events.get(i).getContent().length(), Settings.LENGTH_CONTENT)));
            }
        mm.put("events", subEvents);
        mm.put("detailEventId", eventId);
        }
        if (events == null) {
            return "index";
        }
        
        int numberOfPages = events.size() < Settings.NUMBER_EVENTS_AVAIABLE ? 0
                : (events.size() / Settings.NUMBER_EVENTS_AVAIABLE);
        if (events.size() % Settings.NUMBER_EVENTS_AVAIABLE != 0) {
            numberOfPages += 1;
        }
        mm.put("events", subEvents);
        mm.put("numberOfPages", numberOfPages);
        mm.put("currentPage", 1);
        return "event_detail";
    }
}
