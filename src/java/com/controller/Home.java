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
import com.utils.Settings;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Phu Ba Duong, Der
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
        List<Event> subEvents = new ArrayList<>();
        offerIpl = new OfferIpl();
        List<Offer> offers = offerIpl.getOffres();

        if (accounts != null) {
            List<Account> subAccounts = accounts.subList(0, Math.min(
                    Settings.NUMBER_OF_NEW_ACCOUNT, accounts.size()));
            mm.put("accounts", subAccounts);
        }
        if (events != null) {
            subEvents = events.subList(0, Math.min(
                    Settings.NUMBER_EVENTS_AVAIABLE, events.size()));
            for (int i = 0; i < subEvents.size(); i++) {
                subEvents.get(i).setContent(subEvents.get(i).getContent().substring(0,
                        Math.min(events.get(i).getContent().length(), Settings.LENGTH_CONTENT)));
            }
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
        mm.put("offers", offers);
        return "index";
    }

    @RequestMapping(value = "/nextPage", method = RequestMethod.GET)
    public String listMemberEventNextPage(
            @RequestParam("nextPage") Integer nextNumber, ModelMap mm) {
        if (nextNumber == null) {
            nextNumber = 0;
        }
        eventIpl = new EventIpl();
        List<Event> events = eventIpl.getEvents();
        List<Event> subEvents = new ArrayList<>();
        if (events != null) {
            subEvents = events.subList((nextNumber - 1) * 
                    Settings.NUMBER_EVENTS_AVAIABLE, Math.min((nextNumber - 1) * 
                            Settings.NUMBER_EVENTS_AVAIABLE + 
                            Settings.NUMBER_EVENTS_AVAIABLE, events.size()));
            for (int i = 0; i < subEvents.size(); i++) {
                subEvents.get(i).setContent(subEvents.get(i).getContent().substring(0,
                        Math.min(events.get(i).getContent().length(), 
                                Settings.LENGTH_CONTENT)));
            }
        }

        int numberOfPages = events.size() < Settings.NUMBER_EVENTS_AVAIABLE ? 0
                : (events.size() / Settings.NUMBER_EVENTS_AVAIABLE);
        if (events.size() % Settings.NUMBER_EVENTS_AVAIABLE != 0) {
            numberOfPages += 1;
        }
        mm.put("events", subEvents);
        mm.put("currentPage", nextNumber);
        mm.put("numberOfPages", numberOfPages);
        return "event_next_page";
    }

    @RequestMapping(value = "/login_form", method = RequestMethod.GET)
    public String loginForm(ModelMap mm) {
        mm.addAttribute("account", new Account());
        return "login_form";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String welcome(@ModelAttribute("account") Account account, ModelMap mm, 
            HttpSession session) {
        accountIpl = new AccountIpl();
        Account ac = accountIpl.getAccount(account.getUsername(), 
                account.getPassword());
        if (ac != null) {
            session.setAttribute("current_account", ac);
            session.setAttribute("login", Settings.SUCCESS_STATUS);
        }
        session.setAttribute("login", Settings.FAIL_STATUS);
        return "redirect_index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showForm(HttpSession session) {
        session.invalidate();
        return "redirect_index";
    }
}
