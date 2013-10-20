/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtstore.sessionbean;

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Selection;
import javax.persistence.criteria.Subquery;

/**
 *
 * @author juliantejera
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public List<T> findAll(String query,  Object[] args){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.Query q = getEntityManager().createQuery(
                "FROM " + entityClass.getAnnotation(Named.class).value() + " " + query, 
                entityClass);
        for(int i = 0; i < args.length; ++i)
            q.setParameter(i + 1, args[i]);
        return q.getResultList();   
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    
    public List<T> findRange(int[] range , String query,  Object[] args) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.Query q = getEntityManager().createQuery(
                "FROM " + entityClass.getAnnotation(Named.class).value() + " " + query, 
                entityClass);
        q.setMaxResults(range[1] - range[0]);
        q.setMaxResults(range[0]);
        for(int i = 0; i < args.length; ++i)
            q.setParameter(i + 1, args[i]);
        return q.getResultList();   
    }
    

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    
    
    
}
