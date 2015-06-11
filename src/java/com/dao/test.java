/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Event;
import com.model.Offer;
import java.util.Date;
/**
 * @author lion
 */
public class test {

    public static void main(String[] args) {
        OfferIpl offerIpl = new OfferIpl();
        AccountIpl accountIpl =  new AccountIpl();
        Offer offer = new Offer();
        
        offer.setAccount(accountIpl.getAccount(1));
        offer.setContent("kmskdf msdfmk dfsdsd kfsdkf ksdmksdf");
        offer.setTitle("aasd asdasd");
        offer.setMode((short)1);
        offer.setCreatedDate(new Date());
        
        offerIpl.insertOffer(offer);
    }

}
