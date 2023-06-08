package com.example.capstone_backend.models;

public class ArtworkInGame {
    private Long id;
    private Boolean stolen;

    private Game game;

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
