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
@RequestMapping(value = "/index")
public class Home {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showForm(ModelMap mm) {
        mm.addAttribute("account", new Account());
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(@ModelAttribute("account") Account account, ModelMap mm) {
        mm.put("account", account);
        return "index";
    }
}
