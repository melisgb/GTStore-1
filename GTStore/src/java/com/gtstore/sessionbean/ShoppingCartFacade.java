/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtstore.sessionbean;

import com.gtstore.model.ShoppingCart;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juliantejera
 */
@Stateless
public class ShoppingCartFacade extends AbstractFacade<ShoppingCart> {
    @PersistenceContext(unitName = "GTStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShoppingCartFacade() {
        super(ShoppingCart.class);
    }
    
}
