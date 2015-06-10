/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.AccountIpl;
import com.dao.EventIpl;
import com.model.Account;
import com.model.Event;
import java.util.List;
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
@RequestMapping(value = "")
public class Home {
    
    private AccountIpl accountController;
    private EventIpl eventController;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listMemberEvent(ModelMap mm) {
        accountController = new AccountIpl();
        List<Account> accounts = accountController.getAccountsList();
        accounts = accounts.subList(0, Math.min(5, accounts.size()));
        mm.put("accounts", accounts);
        
        eventController = new EventIpl();
        List<Event> events = eventController.getEvents();
        events = events.subList(0, Math.min(5, events.size()));
//        for (int i = 0; i < events.size(); i++) {
//            events.get(i).setContent(events.get(i).getContent().substring(0, 50));
//        }
        
        mm.put("events", events);
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showForm(ModelMap mm) {
        mm.addAttribute("account", new Account());
        return "login";
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String login(@ModelAttribute("account") Account account, ModelMap mm, HttpSession session) {
        accountController = new AccountIpl();
        Account ac = accountController.getAccount(account.getUsername(), account.getPassword());
        if (ac != null) {
            session.setAttribute("current_account", ac);
            return "redirect_index";
        }
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showForm(HttpSession session) {
        session.invalidate();
        return "redirect_index";
    }
    
}
