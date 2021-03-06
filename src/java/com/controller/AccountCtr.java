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
import com.utils.Settings;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author Phu Ba Duong, Der
 */
@Controller
@RequestMapping(value = "/account")
public class AccountCtr {

    private AccountIpl accountIpl;
    private EventIpl eventIpl;
    private OfferIpl offerIpl;

    public AccountCtr() {
        accountIpl = new AccountIpl();
        eventIpl = new EventIpl();
        offerIpl = new OfferIpl();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/create_account_form", method = RequestMethod.GET)
    public String createAccountForm(ModelMap mm) {
        mm.addAttribute("account", new Account());
        List<String> promotion = new ArrayList<String>();
        for (int i = 1; i <= Settings.NUMBER_PROMOTIONS; i++) {
            promotion.add("" + i);
        }
        mm.put("result", 0);
        mm.addAttribute("promo", promotion);
        return "create_account_form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String signup(@ModelAttribute("account") Account account, ModelMap mm,
            @RequestParam("file") MultipartFile file) throws Exception {
        
        if (!file.isEmpty()) {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            File destination = new File("/home/lion/Documents/Dropbox/Gestion "
                    + "de projet/Projet/Practice/projetGP/web/images/account/" 
                    + account.getImage());
            ImageIO.write(src, "jpg", destination);
        }
        
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        account.setCreatedDate(date);
        account.setModifiedDate(date);
        Integer result = accountIpl.insertAccount(account);
        mm.put("result", result);
        return "redirect_index";
    }

    @RequestMapping(value = "/edit_account_form", method = RequestMethod.GET)
    public String editAccountForm(@RequestParam("idAccount") int idAccount,
            ModelMap mm, HttpSession session) {
        Account currentAccount;
        currentAccount = accountIpl.getAccount(idAccount);
        if (currentAccount == null) {
            return "redirect_index";
        }
        List<String> promotion = new ArrayList<String>();
        for (int i = 1; i <= Settings.NUMBER_PROMOTIONS; i++) {
            promotion.add("" + i);
        }

        mm.addAttribute("promo", promotion);
        mm.put("current_account", currentAccount);
        session.setAttribute("oldAccount", currentAccount);
        mm.put("result", null);
        return "edit_account_form";
    }

    @RequestMapping(value = "/edit_account", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("current_account") Account newAccount,
            ModelMap mm, HttpSession session, 
            @RequestParam("file") MultipartFile file) throws Exception{
        
        if (!file.isEmpty()) {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            File destination = new File("/home/lion/Documents/Dropbox/Gestion "
                    + "de projet/Projet/Practice/projetGP/web/images/account/" 
                    + newAccount.getImage());
            ImageIO.write(src, "jpg", destination);
        }
        
        Account oldAccount = (Account) session.getAttribute("oldAccount");
        newAccount.setIdAccount(oldAccount.getIdAccount());
        newAccount.setCreatedDate(oldAccount.getCreatedDate());
        newAccount.setModifiedDate(new Date());
        boolean result = accountIpl.updateAccount(newAccount);
        mm.put("result", result);
        return "redirect_index";
    }

    @RequestMapping(value = "/lists_accounts", method = RequestMethod.GET)
    public String listAccounts(ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        List<Account> accounts = accountIpl.getAccountsList();
        List<Account> subAccounts;
        int numberPages = (int) accounts.size() / Settings.NUMBER_OF_ACCOUNT;
        if (accounts.size() - Settings.NUMBER_OF_ACCOUNT > 0) {
            numberPages = (int) accounts.size() / Settings.NUMBER_OF_ACCOUNT + 1;
        }
        subAccounts = accounts.subList(0, Math.min(Settings.NUMBER_OF_ACCOUNT, accounts.size()));
        mm.put("subAccounts", subAccounts);
        if (accounts != null) {
            subAccounts = accounts.subList(0, Math.min(Settings.NUMBER_OF_NEW_ACCOUNT, accounts.size()));
            mm.put("accounts", subAccounts);
        }
        mm.put("numberPages", numberPages);
        mm.put("currentPage", 1);
        mm.put("numberAccounts", Settings.NUMBER_OF_ACCOUNT);

        session.setAttribute("currentListAccount", accounts);
        return "lists_accounts";
    }

    @RequestMapping(value = "/search_accounts", method = RequestMethod.GET)
    public String searchAccounts(@RequestParam("searchInfo") String searchInfo,
            ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        List<Account> search_accounts = accountIpl.getAccounts(searchInfo);
        List<Account> sub_accounts = search_accounts.subList(0, Settings.NUMBER_OF_ACCOUNT);
        int numberPages = (int) search_accounts.size() / Settings.NUMBER_OF_ACCOUNT;
        if (search_accounts.size() % Settings.NUMBER_OF_ACCOUNT > 0) {
            numberPages = (int) search_accounts.size() / Settings.NUMBER_OF_ACCOUNT + 1;
        }
        mm.put("search_accounts", sub_accounts);
        mm.put("numberPages", numberPages);
        mm.put("currentPage", 1);
        mm.put("numberAccounts", Settings.NUMBER_OF_ACCOUNT);

        session.setAttribute("currentListAccount", search_accounts);
        return "search_accounts";
    }

    @RequestMapping(value = "/search_members", method = RequestMethod.GET)
    public String searchMembers(@RequestParam("userName") String username,
            ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        List<Account> accountsFound = accountIpl.getAccounts(username);
        int numberAccounts = Math.min(accountsFound.size(), Settings.NUMBER_OF_ACCOUNT);
        List<Account> subAccounts = accountsFound.subList(0, numberAccounts);
        mm.put("membersFound", subAccounts);
        mm.put("numberAccounts", numberAccounts);
        return "members_found";
    }

    @RequestMapping(value = "/searchDetail", method = RequestMethod.GET)
    public String searchDetail(@RequestParam("nom") String username,
            @RequestParam("promotion") int promotion, @RequestParam("mail") String mail,
            ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        if(username.equalsIgnoreCase("default"))
            username = null;
        if(mail.equalsIgnoreCase("default"))
            mail = null;
        List<Account> accountsFound = accountIpl.getAccountsSearchDetail(username, promotion, mail);
        int numberAccounts = Math.min(accountsFound.size(), Settings.NUMBER_OF_ACCOUNT);
        List<Account> search_accounts = accountsFound.subList(0, numberAccounts);
        
        int numberPages = (int) search_accounts.size() / Settings.NUMBER_OF_ACCOUNT;
        if (search_accounts.size() % Settings.NUMBER_OF_ACCOUNT > 0) {
            numberPages = (int) search_accounts.size() / Settings.NUMBER_OF_ACCOUNT + 1;
        }
        mm.put("numberPages", numberPages);
        mm.put("currentPage", 1);
        mm.put("search_accounts", search_accounts);
        mm.put("numberAccounts", numberAccounts);
        return "search_accounts";
    }

    @RequestMapping(value = "/next_page", method = RequestMethod.GET)
    public String nextPage(@RequestParam("page") int page, ModelMap mm, HttpSession session) {
        accountIpl = new AccountIpl();
        List<Account> accounts = (List<Account>) session.getAttribute("currentListAccount");
        List<Account> sub_accounts = accounts.subList(page * Settings.NUMBER_OF_ACCOUNT,
                Math.min(page * Settings.NUMBER_OF_ACCOUNT + Settings.NUMBER_OF_ACCOUNT, accounts.size()));
        int numberPages = (int) accounts.size() / Settings.NUMBER_OF_ACCOUNT;
        if (accounts.size() % Settings.NUMBER_OF_ACCOUNT > 0) {
            numberPages = (int) accounts.size() / Settings.NUMBER_OF_ACCOUNT + 1;
        }
        mm.put("search_accounts", sub_accounts);
        mm.put("numberPages", numberPages);
        mm.put("currentPage", page + 1);
        mm.put("numberAccounts", Settings.NUMBER_OF_ACCOUNT);
        return "search_accounts";
    }

    @RequestMapping(value = "/exportToExcel", method = RequestMethod.GET)
    public ModelAndView getExcel() {
        List<Account> accounts = accountIpl.getAccountsList();
        return new ModelAndView("Accounts", "accounts", accounts);
    }
}
