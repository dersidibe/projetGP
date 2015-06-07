/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.AccountController;
import com.model.Account;
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
//@RequestMapping(value = "/index")
@RequestMapping(value = "")
public class Home {

    private AccountController accountController;

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
            session.setAttribute("username", ac.getUsername());
            return "index";
        }
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showForm(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
