/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtstore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author juliantejera
 */
@Entity
@Table(name="ShoppingCart")
public class ShoppingCart implements Serializable {
    
    /**
     * Games in the shopping cart
     */
    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartGame> shoppingCartGames;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Date of creation of shopping cart
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="createdAt")
    private Date createdAt;
    
    // Associations
    
    /**
     * User whom owns the cart
     */
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    
    /**
     * Movies in the cart
     */
    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartMovie> shoppingCartMovies;
    
    /**
     * Songs in the cart
     */
    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartSong> shoppingCartSongs;
    
    
    @OneToMany(mappedBy = "shoppingCart")
    private List<Purchase> purchases;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShoppingCartMovie> getShoppingCartMovies() {
        return shoppingCartMovies;
    }

    public void setShoppingCartMovies(List<ShoppingCartMovie> shoppingCartMovies) {
        this.shoppingCartMovies = shoppingCartMovies;
    }

    public List<ShoppingCartSong> getShoppingCartSongs() {
        return shoppingCartSongs;
    }

    public void setShoppingCartSongs(List<ShoppingCartSong> shoppingCartSongs) {
        this.shoppingCartSongs = shoppingCartSongs;
    }


    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingCart)) {
            return false;
        }
        ShoppingCart other = (ShoppingCart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.juliantejera.jstore.ShoppingCart[ id=" + id + " ]";
    }
    
}
