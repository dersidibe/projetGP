/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Account;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lion
 */
public class test {

    public static void main(String[] args) {

//       // AccountIpl accountController = new AccountIpl();
//       // Account ac = accountController.getAccount("duong", "123");
//        System.out.print("  " +date());
        
//               DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//       //get current date time with Date()
//       Date date = new Date();
//       System.out.println(dateFormat.format(date));
//
//       //get current date time with Calendar()
//       Calendar cal = Calendar.getInstance();
//       System.out.println(cal.getTime());
        
        java.util.Date utilDate = new Date();
        java.sql.Timestamp times;
        times = new Timestamp(System.currentTimeMillis());
        System.out.println("date="+times);
    }

}
