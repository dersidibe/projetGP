/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.AccountIpl;
import com.model.Account;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */

@Controller
@RequestMapping(value = "/account")
public class AccountCtr {

    private AccountIpl accountIpl;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String submitForm(ModelMap mm) {
        mm.addAttribute("account", new Account());
        List<String> promotion = new ArrayList<String>();
        for (int i = 1; i <= 18; i++) {
            promotion.add("" + i);
        }
        mm.put("result", 0);
        mm.addAttribute("promo", promotion);
        return "signup";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String signup(@ModelAttribute("account") Account account, ModelMap mm) {
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        accountIpl = new AccountIpl();
        account.setCreatedDate(date);
        account.setModifiedDate(date);
        Integer result = accountIpl.insertAccount(account);
        mm.put("result", result);
        return "signup";
    }
    
    @RequestMapping(value="/edit_account", method = RequestMethod.POST)
    public String formEdit(ModelMap mm, HttpSession session)
    {
        Account current_account = (Account) session.getAttribute("current_account");
        mm.put("current_account", current_account);
        return "edit_account";
    }
}
