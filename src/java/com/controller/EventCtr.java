/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.EventIpl;
import com.model.Account;
import com.model.Event;
import java.text.SimpleDateFormat;
import java.util.Date;
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

/**
 *
 * @author lion
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

    @RequestMapping(value = "/create_event", method = RequestMethod.GET)
    public String createEvent(ModelMap mm, HttpSession session) {
        Event event = new Event();
        Account currentAccount = (Account) session.getAttribute("current_account");
        if (currentAccount == null) {
            return "redirect_index";
        }
        mm.put("result", 0);
        mm.addAttribute("event", event);
        return "create_event";
    }

    @RequestMapping(value = "/do_creation_event", method = RequestMethod.POST)
    public String doCreationEvent(@ModelAttribute("event") Event event,
            ModelMap mm, HttpSession session) {
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

    @RequestMapping(value = "/edit_event", method = RequestMethod.GET)
    public String formEdit(@RequestParam("eventId") int eventId, ModelMap mm, 
            HttpSession session) {
        eventIpl = new EventIpl();
        Event current_event = eventIpl.getEvent(eventId);
        mm.put("current_event", current_event);
        session.setAttribute("eventCreatedDate", current_event.getCreatedDate());
        mm.put("eventId", eventId);
        mm.put("result", null);
        return "edit_event";
    }

    @RequestMapping(value = "/do_edition", method = RequestMethod.POST)
    public String doEdition(@RequestParam("eventId") int eventId,
            @ModelAttribute("current_event") Event current_event,
            ModelMap mm, HttpSession session) {
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
}
