package com.dao;

import com.model.Offer;
import java.util.List;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public abstract class OfferDao {
 
    public abstract List<Offer> getOffres();
    
    public abstract List<Offer> getOffresByIdUser(int idUser);
    
    public abstract Offer getEvent(int id);
    
    public abstract Integer insertOffer(Offer offre);

    public abstract boolean deleteOffer(Offer offre);

    public abstract boolean updateOffer(Offer offre);
}
