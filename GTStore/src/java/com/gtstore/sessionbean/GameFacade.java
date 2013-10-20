/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtstore.sessionbean;

import com.gtstore.model.Game;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juliantejera
 */
@Stateless
public class GameFacade extends AbstractFacade<Game> {
    @PersistenceContext(unitName = "GTStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameFacade() {
        super(Game.class);
    }
    
}
