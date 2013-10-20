/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtstore.sessionbean;

import com.gtstore.model.ShoppingCartMovie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juliantejera
 */
@Stateless
public class ShoppingCartMovieFacade extends AbstractFacade<ShoppingCartMovie> {
    @PersistenceContext(unitName = "GTStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShoppingCartMovieFacade() {
        super(ShoppingCartMovie.class);
    }
    
}
