/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtstore.model;

import java.io.Serializable;
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


/**
 *
 * @author juliantejera
 */
@Entity
@Table(name="Game")
public class Game implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Title of the game
     */
    @Column(name="title")
    private String title;
    /**
     * Price of the game
     */
    @Column(name="price")
    private Double price;
    
    
    // Associations
    /**
     * Genre of the game
     */
    @ManyToOne
    private GameGenre gameGenre;
    
    
    @ManyToMany()
    @JoinTable(name = "game_cart", joinColumns = {
        @JoinColumn(name = "id", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false)})
    private List<ShoppingCart> shoppingCart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public GameGenre getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(GameGenre gameGenre) {
        this.gameGenre = gameGenre;
    }

    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
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
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gtstore.model.Game[ id=" + id + " ]";
    }
    
}
