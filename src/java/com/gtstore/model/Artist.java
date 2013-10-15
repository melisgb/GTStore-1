/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtstore.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author juliantejera
 */
@Entity
public class Artist implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    private String name;
    private Boolean isBand;
    private String gender;
    
    // Associations
    
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;
    @OneToMany(mappedBy = "artist")
    private List<Song> songs;
    @OneToMany(mappedBy = "artist")
    private List<SongFeaturing> songFeaturings;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsBand() {
        return isBand;
    }

    public void setIsBand(Boolean isBand) {
        this.isBand = isBand;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<SongFeaturing> getSongFeaturings() {
        return songFeaturings;
    }

    public void setSongFeaturings(List<SongFeaturing> songFeaturings) {
        this.songFeaturings = songFeaturings;
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
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.juliantejera.jstore.Artist[ id=" + id + " ]";
    }
    
}