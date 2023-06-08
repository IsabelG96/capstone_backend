package com.example.capstone_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="artworks")
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="artist")
    private String artist;

    @Column(name = "title")
    private String title;

    @Column(name="value")
    private int value;

    @Column(name="rarity")
    @Enumerated(EnumType.STRING)
    private RarityLevel rarityLevel;

    @Column(name="url")
    private String url;

    @JsonIgnoreProperties({"artwork", "games"})
    @OneToMany(mappedBy = "artwork")
    private List<ArtworkInGame> games;




    public Artwork(String artist, String title, int value, RarityLevel rarityLevel, String url) {
        this.artist = artist;
        this.title = title;
        this.value = value;
        this.rarityLevel = rarityLevel;
        this.url = url;
        this.games = new ArrayList<>();
    }

    public Artwork(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RarityLevel getRarityLevel() {
        return rarityLevel;
    }

    public void setRarityLevel(RarityLevel rarityLevel) {
        this.rarityLevel = rarityLevel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ArtworkInGame> getGames() {
        return games;
    }

    public void setGames(List<ArtworkInGame> games) {
        this.games = games;
    }
}
