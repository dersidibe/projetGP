/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Account;
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
@RequestMapping(value = "/welcome")
public class Welcome {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value="account")Account account, ModelMap mm) {
        mm.put("account1", account);
        return "welcome";
    }
    
    @RequestMapping(value="/createAccount", method = RequestMethod.POST)
    public String createAccount(){
        return "welcome";
    }

}
