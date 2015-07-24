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
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Der
 */
public class AccountIpl extends AccountDao {

    private SessionFactory sessionFactory = null;
    private Session session = null;

    public AccountIpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Account> getAccountsList() {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Account> listAccount = null;
        try {
            transaction = session.beginTransaction();
            listAccount = session.createQuery("from Account order by created_date desc").list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return listAccount;
        }
    }

    @Override
    public Account getAccount(int id) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Account account = null;
        try {
            transaction = session.beginTransaction();
            account = (Account) session.get(Account.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return account;
        }

    }

    public Account getAccount(String username, String password) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Account> account = null;
        try {
            transaction = session.beginTransaction();
            String stringQuery = "from Account as a where a.username = :usr and a.password = :pwd ";
            Query query = session.createQuery(stringQuery);
            query.setString("usr", username);
            query.setString("pwd", password);
            account = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            if (account != null && account.size() > 0) {
                return account.get(0);
            }
            return null;
        }
    }

    public List<Account> getAccounts(String searchInfo) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Account> accounts = null;
        try {
            transaction = session.beginTransaction();
            String stringQuery = "from Account as a where lower(a.username) like lower(:searchInfo) ";
            Query query = session.createQuery(stringQuery);
            query.setString("searchInfo", "%" + searchInfo + "%");
            accounts = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return accounts;
        }
    }
    
    public List<Account> getAccountsSearchDetail(String nom, int promotion, String mail) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Account> accounts = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            
            String stringQuery = "from Account as a where 1=1";
            if(nom != null && !nom.equals(""))
                stringQuery = stringQuery + " and lower(a.username) like lower('%" + nom + "%')";
            if(promotion > 0)
                stringQuery = stringQuery + " and a.promotion = " + promotion;
            if(mail != null && !mail.equals(""))
                stringQuery = stringQuery + " and lower(a.email) like lower('%" + mail+ "%')";
            Query query = session.createQuery(stringQuery);
            System.out.print("bbbbbbbbbbbbbbbbb" + stringQuery);
            accounts = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return accounts;
        }
    }

    @Override
    public Integer insertAccount(Account account) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer accountId = null;
        try {
            transaction = session.beginTransaction();
            accountId = (Integer) session.save(account);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return accountId;
        }
    }

    @Override
    public boolean deleteAccount(Account account) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
            result = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return result;
        }

    }

    @Override
    public boolean updateAccount(Account account) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.flush();
            session.update(account);
            transaction.commit();
            result = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return result;
        }
    }
}
