/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Account;

/**
 *
 * @author lion
 */
public class test {

    public static void main(String[] args) {

        AccountIpl accountController = new AccountIpl();
        Account ac = accountController.getAccount("duong", "123");
        System.out.print(ac.getUsername() + "  " + ac.getEmail());
    }

}
