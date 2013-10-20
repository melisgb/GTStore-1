/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.controller;

import com.gtstore.model.User;
import com.gtstore.sessionbean.UserFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author carlosjosetoribio
 */
@Named("uiLoginController")
@SessionScoped
public class LoginController implements Serializable{
    
    private User current;
    public User getCurrent() {
        if (current == null) current = new User();
        return current;
    }
    
    @EJB
    private com.gtstore.sessionbean.UserFacade ejbFacade;

    private UserFacade getFacade() {
        return ejbFacade;
    }

    public String authenticate() {
        Object[] args = { current.getUsername() , current.getPassword() };
        List<User> usrs = getFacade().findAll(
                "obj WHERE obj.username = (?1) and obj.password = (?2)", 
                args);
        if(usrs.isEmpty())return "login";
        return "home";
    }
    
}
