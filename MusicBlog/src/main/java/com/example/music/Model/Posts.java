package com.example.music.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Table
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column
    private String artist;
    @Lob
    @Column
    @NotEmpty
    private String album;
    @Column
    private String description;
    @Column
    private String genre;
    @Column
    @NotBlank
    private String songUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", songUrl='" + songUrl + '\'' +
                '}';
    }
}



