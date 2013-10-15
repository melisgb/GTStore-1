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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author juliantejera
 */
@Entity
public class Song implements Serializable {
    @OneToOne
    private SongFeaturing songFeaturing;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Double price;
    
    // Associations
    
    @ManyToOne
    @JoinColumn(name="artistId")
    private Artist artist;
    @OneToOne
    @JoinColumn(name="musicGenreId")
    private MusicGenre musicGenre;

    
    @OneToMany(mappedBy = "song")
    private List<AlbumSong> albumSongs;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SongFeaturing getSongFeaturing() {
        return songFeaturing;
    }

    public void setSongFeaturing(SongFeaturing songFeaturing) {
        this.songFeaturing = songFeaturing;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    public List<AlbumSong> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(List<AlbumSong> albumSongs) {
        this.albumSongs = albumSongs;
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
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.juliantejera.jstore.Song[ id=" + id + " ]";
    }
    
}
