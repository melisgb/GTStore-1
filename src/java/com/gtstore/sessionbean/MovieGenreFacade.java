/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtstore.sessionbean;

import com.gtstore.model.MovieGenre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juliantejera
 */
@Stateless
public class MovieGenreFacade extends AbstractFacade<MovieGenre> {
    @PersistenceContext(unitName = "GTStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovieGenreFacade() {
        super(MovieGenre.class);
    }
    
}
