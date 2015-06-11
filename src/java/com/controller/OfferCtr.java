/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.EventIpl;
import com.dao.OfferIpl;
import com.model.Account;
import com.model.Event;
import com.model.Offer;
import java.util.Date;
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
@RequestMapping(value = "/offer")
public class OfferCtr {

    private OfferIpl offerIpl;

    @RequestMapping(value = "/create_offer", method = RequestMethod.GET)
    public String createOffer(ModelMap mm, HttpSession session) {
        Offer offer = new Offer();
        Account account = (Account) session.getAttribute("current_account");
        if (account == null) {
            return "redirect_index";
        }
        mm.addAttribute("offer", offer);
        return "create_offer";
    }

    @RequestMapping(value = "/do_creation_offer", method = RequestMethod.POST)
    public String doCreationOffer(@ModelAttribute("offer") Offer offer, ModelMap mm, HttpSession session) {
        offerIpl = new OfferIpl();
        offer.setAccount((Account) session.getAttribute("current_account"));
        offer.setCreatedDate(new Date());

        offerIpl.insertOffer(offer);
        return "redirect_index";
    }
}
