/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.AccountController;
import com.dao.EventController;
import com.model.Account;
import com.model.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author lion
 */
@Controller
//@RequestMapping(value = "/index")
@RequestMapping(value = "")
public class Home {
    
    private AccountController accountController;
    private EventController eventController;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listMemberEvent(ModelMap mm) {
        accountController = new AccountController();
        List<Account> accounts = accountController.getAccountsList();
        accounts = accounts.subList(0, Math.min(5, accounts.size()));
        mm.put("accounts", accounts);
        
        eventController = new EventController();
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
        accountController = new AccountController();
        Account ac = accountController.getAccount(account.getUsername(), account.getPassword());
        if (ac != null) {
            session.setAttribute("username", ac);
            return "index";
        }
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showForm(HttpSession session) {
        session.invalidate();
        return "index";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String submitForm(ModelMap mm) {
        mm.addAttribute("account", new Account());
        return "signup";
    } 
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String signup(@ModelAttribute("account") Account account, ModelMap mm, HttpSession session) {
        accountController = new AccountController();
        Account ac = new Account();
        //Account ac = accountController.getAccount(account.getUsername(), account.getPassword());
       
        return "signup";
    }    
    public void initModelList(Model model) {
	        List<String> promotion = new ArrayList<String>();
                
                for(int i = 0; i<18; i++){
                    i++;
                    promotion.add(""+i);
                }
	        model.addAttribute("promo", promotion);
    } 
    protected Map referenceData(HttpServletRequest request) throws Exception {
  
        Map promotions = new HashMap();
        List<String> promoList = new ArrayList<String>();
        promoList.add("Gardening");
        promoList.add("Listening Music");
        promoList.add("Writing Technical Tutorials");
        promotions.put("hobbiesList", promoList);
  
        return promotions;
  
    }    
    
}
