package com.dao;

import com.model.Offer;
import com.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 * @author Phu Ba Duong ameniorer
 */
public class OfferIpl extends OfferDao {

    private Session session = null;
    private SessionFactory sessionFactory = null;

    public OfferIpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Offer> getOffres() {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Offer> list = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery("from Offer").list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return list;
        }
    }

    @Override
    public List<Offer> getOffresByIdUser(int idUser) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Offer> list = null;
        try {
            transaction = session.beginTransaction();
            String query = "from Offer as o where o.account.idAccount=" + idUser;
            list = session.createQuery(query).list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return list;
        }
    }

    @Override
    public Offer getEvent(int id) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Offer offre = null;
        try {
            transaction = session.beginTransaction();
            offre = (Offer) session.get(Offer.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return offre;
        }
    }

    @Override
    public Integer insertOffer(Offer offre) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer idOffer = null;
        try {
            transaction = session.beginTransaction();
            idOffer = (Integer) session.save(offre);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            return idOffer;
        }
    }

    @Override
    public boolean deleteOffer(Offer offre) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.delete(offre);
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
    public boolean updateOffer(Offer offre) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.update(offre);
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
