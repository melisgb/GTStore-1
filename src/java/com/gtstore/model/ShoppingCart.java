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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    private static final long serialVersionUID = 1L;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="createdAt")
    private Date createdAt;
    
    
    @Column(name="name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    
    
    @ManyToMany()
    @JoinTable(name = "movie_cart", joinColumns = {
        @JoinColumn(name = "id", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false)})
    private List<Movie> shoppingCartMovies;
    
    
    @ManyToMany()
    @JoinTable(name = "song_cart", joinColumns = {
        @JoinColumn(name = "id", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false)})
    private List<Song> shoppingCartSongs;
    
    @ManyToMany()
    @JoinTable(name = "game_cart", joinColumns = {
        @JoinColumn(name = "id", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false)})
    private List<Game> shoppingCartGames;
    
    
    @OneToMany(mappedBy = "shoppingCart")
    private List<Purchase> purchases;

    public ShoppingCart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
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

    

    public ShoppingCart(Long id, Date createdAt, String name, User user, List<Movie> shoppingCartMovies, List<Song> shoppingCartSongs, List<Game> shoppingCartGames, List<Purchase> purchases) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.user = user;
        this.shoppingCartMovies = shoppingCartMovies;
        this.shoppingCartSongs = shoppingCartSongs;
        this.shoppingCartGames = shoppingCartGames;
        this.purchases = purchases;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    
    
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    
    public List<Movie> getShoppingCartMovies() {
        return shoppingCartMovies;
    }
    public void setShoppingCartMovies(List<Movie> shoppingCartMovies) {
        this.shoppingCartMovies = shoppingCartMovies;
    }
    

    public List<Game> getShoppingCartGames() {
        return this.shoppingCartGames;
    }
    public void setShoppingCartGames(List<Game> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    
    public List<Song> getShoppingCartSongs() {
        return shoppingCartSongs;
    }
    public void setShoppingCartSongs(List<Song> shoppingCartSongs) {
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
