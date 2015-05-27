/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;
import com.model.Account;

/**
 *
 * @author Der
 */
public abstract class AccountDao {

    public abstract List<Account> getAccountsList();

    public abstract Account getAccount(int id);

    public abstract Integer insertAccount(Account account);

    public abstract boolean deleteAccount(Account account);

    public abstract boolean updateAccount(Account account);
}
