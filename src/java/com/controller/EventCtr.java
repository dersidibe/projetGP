/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.EventIpl;
import com.model.Account;
import com.model.Event;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author lion
 */
@Controller
@RequestMapping(value = "/event")
public class EventCtr {

    private EventIpl evenController;

    @RequestMapping(value = "/create_event", method = RequestMethod.GET)
    public String createEvent(ModelMap mm) {
        mm.addAttribute("event", new Event());
        return "create_event";
    }

    @RequestMapping(value = "/do_creation_event", method = RequestMethod.POST)
    public String doCreationEvent(@ModelAttribute("event") Event event, ModelMap mm, HttpSession session) {
        evenController = new EventIpl();
        evenController.insertEvent(event);
        return "redirect_index";
    }
}
