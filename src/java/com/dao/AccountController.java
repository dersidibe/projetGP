/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dao.AccountDao;
import java.util.List;
import com.model.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.utils.HibernateUtil;

/**
 *
 * @author Der
 */
public class AccountController extends AccountDao{

     private Session session = null;
     
     public AccountController(){
         
         this.session = HibernateUtil.getSessionFactory().openSession();
     }
    
    @Override
    public List<Account> getAccountsList() {
        
        Transaction transaction = null;
        try{
            
            transaction.begin();
            List<Account> listAccount = session.createQuery("from Account").list();
            transaction.commit();
            return listAccount;
            
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return null;
        
    }

    @Override
    public Account getAccount(int id) {
        
        Transaction transaction = null;
        try{
            
            transaction.begin();
            Account listAccount = (Account) session.get(Account.class, id);
            transaction.commit();
            return listAccount;
            
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
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
        boolean result =  false;
        try {
            transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
            result =  true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateAccount(Account account) {
        
        Transaction transaction = null;
        boolean result =  false;
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
