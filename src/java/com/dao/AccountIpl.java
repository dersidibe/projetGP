/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;
import com.model.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.utils.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author Der
 */
public class AccountIpl extends AccountDao {

    private Session session = null;

    public AccountIpl() {

        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public List<Account> getAccountsList() {

        Transaction transaction = null;
        List<Account> listAccount = null;

        try {

            transaction = session.beginTransaction();
            listAccount = session.createQuery("from Account order by created_date desc").list();
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return listAccount;

    }

    @Override
    public Account getAccount(int id) {

        Transaction transaction = null;
        Account account = null;

        try {

            transaction = session.beginTransaction();
            account = (Account) session.get(Account.class, id);
            transaction.commit();

        } catch (HibernateException e) {

            e.printStackTrace();
        }

        return account;
    }

    public Account getAccount(String username, String password) {

        Transaction transaction = null;
        List<Account> account = null;

        try {
            transaction = session.beginTransaction();
            String stringQuery = "from Account as a where a.username = :usr and a.password = :pwd ";
            Query  query = session.createQuery(stringQuery);
            query.setString("usr",username);
            query.setString("pwd",password);
            account = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        if(account != null && account.size() > 0)
            return account.get(0);
        return null;
    }

    @Override
    public Integer insertAccount(Account account) {

        Transaction transaction = null;
        Integer accountId = null;

        try {

            transaction = session.beginTransaction();
            accountId = (Integer) session.save(account);
            transaction.commit();

        } catch (HibernateException e) {

            e.printStackTrace();
        }

        return accountId;
    }

    @Override
    public boolean deleteAccount(Account account) {

        Transaction transaction = null;
        boolean result = false;

        try {

            transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
            result = true;

        } catch (HibernateException e) {

            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean updateAccount(Account account) {

        Transaction transaction = null;
        boolean result = false;

        try {

            transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
            result = true;

        } catch (HibernateException e) {

            e.printStackTrace();
        }
        return result;
    }
}
