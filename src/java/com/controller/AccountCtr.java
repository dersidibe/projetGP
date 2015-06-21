/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.AccountIpl;
import com.model.Account;
import com.utils.Paramaters;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
@Controller
@RequestMapping(value = "/account")
public class AccountCtr {

    private AccountIpl accountIpl;

    public AccountCtr() {
        accountIpl = new AccountIpl();
    }

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
        for (int i = 1; i <= Paramaters.NUMBER_PROMOTIONS; i++) {
            promotion.add("" + i);
        }
        mm.put("result", 0);
        mm.addAttribute("promo", promotion);
        return "signup";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String signup(@ModelAttribute("account") Account account, ModelMap mm) {
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
//        accountIpl = new AccountIpl();
        account.setCreatedDate(date);
        account.setModifiedDate(date);
        Integer result = accountIpl.insertAccount(account);
        mm.put("result", result);
        return "signup";
    }

    @RequestMapping(value = "/edit_account", method = RequestMethod.GET)
    public String formEdit(@RequestParam("idAccount") int idAccount,
            ModelMap mm, HttpSession session) {
        Account currentAccount;
        currentAccount = accountIpl.getAccount(idAccount);
        if (currentAccount == null) {
            return "redirect_index";
        }
        List<String> promotion = new ArrayList<String>();
        for (int i = 1; i <= Paramaters.NUMBER_PROMOTIONS; i++) {
            promotion.add("" + i);
        }
        
        mm.addAttribute("promo", promotion);
        mm.put("current_account", currentAccount);
        session.setAttribute("oldAccount", currentAccount);
        mm.put("result", null);
        return "edit_account";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String doEdition(@ModelAttribute("current_account") Account newAccount,
            ModelMap mm, HttpSession session) {
        Account oldAccount = (Account) session.getAttribute("oldAccount");
        newAccount.setIdAccount(oldAccount.getIdAccount());
        newAccount.setCreatedDate(oldAccount.getCreatedDate());
        newAccount.setModifiedDate(new Date());
        boolean result = accountIpl.updateAccount(newAccount);
        mm.put("result", result);
        return "edit_account";
    }
    
    @RequestMapping(value = "/lists_accounts", method = RequestMethod.GET)
    public String listAccounts(ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        List<Account> accounts = accountIpl.getAccountsList();
        int numberPages = (int) accounts.size()/ Paramaters.NUMBER_OF_ACCOUNT + 1;
        List<Account> sub_accounts = accounts.subList(0, Paramaters.NUMBER_OF_ACCOUNT);
        
        mm.put("accounts", sub_accounts);
        mm.put("numberPages", numberPages);
        mm.put("currentPage", 1);
        mm.put("numberAccounts", Paramaters.NUMBER_OF_ACCOUNT);
        
        session.setAttribute("currentListAccount", accounts);
        return "lists_accounts";
    }
    
    @RequestMapping(value = "/search_accounts", method = RequestMethod.GET)
    public String searchAccounts(@RequestParam("searchInfo") String searchInfo, 
            ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        List<Account> search_accounts = accountIpl.getAccounts(searchInfo);
        List<Account> sub_accounts = search_accounts.subList(0, Paramaters.NUMBER_OF_ACCOUNT);
        int numberPages = (int) search_accounts.size()/ Paramaters.NUMBER_OF_ACCOUNT + 1;
        
        mm.put("search_accounts", sub_accounts);
        mm.put("numberPages", numberPages);
        mm.put("currentPage", 1);
        mm.put("numberAccounts", Paramaters.NUMBER_OF_ACCOUNT);
        
        session.setAttribute("currentListAccount", search_accounts);
        return "search_accounts";
    }
    
    @RequestMapping(value = "/next_page", method = RequestMethod.GET)
    public String nextPage(@RequestParam("page") int page, ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        List<Account> accounts = (List<Account>) session.getAttribute("currentListAccount");
        List<Account> sub_accounts = accounts.subList(page * Paramaters.NUMBER_OF_ACCOUNT, 
                Math.min(page * Paramaters.NUMBER_OF_ACCOUNT + Paramaters.NUMBER_OF_ACCOUNT, accounts.size()));
        int numberPages = (int) accounts.size()/ Paramaters.NUMBER_OF_ACCOUNT + 1;
        
        mm.put("search_accounts", sub_accounts);
        mm.put("numberPages", numberPages);
        mm.put("currentPage", page + 1);
        mm.put("numberAccounts", Paramaters.NUMBER_OF_ACCOUNT);
        
        return "search_accounts";
    }
}
