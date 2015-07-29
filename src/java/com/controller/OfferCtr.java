/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.OfferIpl;
import com.model.Account;
import com.model.Offer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Phu Ba Duong
 */
@Controller
@RequestMapping(value = "/offer")
public class OfferCtr {

    private OfferIpl offerIpl;

    @RequestMapping(value = "/create_offer_form", method = RequestMethod.GET)
    public String createOfferForm(ModelMap mm, HttpSession session) {
        Offer offer = new Offer();
        Account account = (Account) session.getAttribute("current_account");
        if (account == null) {
            return "redirect_index";
        }
        mm.put("result", 0);
        mm.addAttribute("offer", offer);
        return "create_offer_form";
    }

    @RequestMapping(value = "/create_offer", method = RequestMethod.POST)
    public String createOffer(@ModelAttribute("offer") Offer offer, ModelMap mm,
            HttpSession session, @RequestParam("file") MultipartFile file) throws Exception {

        if (!file.isEmpty()) {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            File destination = new File("/home/lion/Documents/Dropbox/Gestion "
                    + "de projet/Projet/Practice/projetGP/web/images/offer/" + offer.getImage());
            ImageIO.write(src, "jpg", destination);
        }
        offerIpl = new OfferIpl();
        Account currentAccount = (Account) session.getAttribute("current_account");
        if (currentAccount == null) {
            return "redirect_index";
        }
        offer.setAccount(currentAccount);
        offer.setCreatedDate(new Date());
        Integer result = offerIpl.insertOffer(offer);
        mm.put("result", result);
        return "redirect_index";
    }
}
