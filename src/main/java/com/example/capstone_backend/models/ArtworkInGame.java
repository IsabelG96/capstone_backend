package com.example.capstone_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="artworksInGame")
public class ArtworkInGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stolen")
    private Boolean stolen;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    @JsonIgnoreProperties({"gameArtworkList", "player"})
    private Game game;

    @ManyToOne
    @JoinColumn(name = "artwork_id", nullable = false)
    @JsonIgnoreProperties({"artworksInGameList"})
    private Artwork artwork;

    public ArtworkInGame(Game game, Artwork artwork) {
        this.stolen = false;
        this.game = game;
        this.artwork = artwork;
    }

    public ArtworkInGame(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStolen() {
        return stolen;
    }

    public void setStolen(Boolean stolen) {
        this.stolen = stolen;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }


}
