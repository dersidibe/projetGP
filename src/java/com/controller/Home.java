/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.AccountIpl;
import com.dao.EventIpl;
import com.dao.OfferIpl;
import com.model.Account;
import com.model.Event;
import com.model.Offer;
import com.utils.Paramaters;
import java.util.ArrayList;
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
public class Home {

    private AccountIpl accountIpl;
    private EventIpl eventIpl;
    private OfferIpl offerIpl;
    
    public Home() {
        accountIpl = new AccountIpl();
        eventIpl = new EventIpl();
        offerIpl = new OfferIpl();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listMemberEvent(ModelMap mm) {
        accountIpl = new AccountIpl();
        List<Account> accounts = accountIpl.getAccountsList();
        eventIpl = new EventIpl();
        List<Event> events = eventIpl.getEvents();
        offerIpl = new OfferIpl();
        List<Offer> offers = offerIpl.getOffres();

        if (accounts != null) {
            List<Account> subAccounts = accounts.subList(0, Math.min(5, accounts.size()));
            mm.put("accounts", subAccounts);
        }
        if (events != null) {
            List<Event> subEvents = events.subList(0, Math.min(Paramaters.NUMBER_EVENTS_AVAIABLE, events.size()));
            for (int i = 0; i < subEvents.size(); i++) {
                subEvents.get(i).setContent(
                        subEvents.get(i).getContent().substring(0,
                                Math.min(events.get(i).getContent().length(), Paramaters.LENGTH_CONTENT)));
            }
        }
        mm.put("events", events);
        mm.put("offers", offers);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showForm(ModelMap mm) {
        mm.addAttribute("account", new Account());
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String login(@ModelAttribute("account") Account account, ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        Account ac = accountIpl.getAccount(account.getUsername(), account.getPassword());
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

    @RequestMapping(value = "/lists_accounts", method = RequestMethod.GET)
    public String listAccounts(ModelMap mm) {
        accountIpl = new AccountIpl();
        List<Account> accounts = accountIpl.getAccountsList();
        mm.put("accounts", accounts);
        return "lists_accounts";
    }
}
