package com.example.capstone_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "penalty")
    private int penalty;

    @Column(name = "score")
    private int score;

    @Column(name= "complete")
    private Boolean complete;

    @ManyToOne
    @JoinColumn(name= "player_id")
    @JsonIgnoreProperties({"artworksInGameList"})
    private Player player;

    @JsonIgnoreProperties({"artworksInGameList", "artwork"})
    @OneToMany(mappedBy = "game")
    private List<ArtworkInGame> gameArtworkList;

    public Game(Player player) {
        this.penalty = 0;
        this.score = 0;
        this.complete = false;
        this.player = player;
        this.gameArtworkList = new ArrayList<>();
    }

    public Game(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<ArtworkInGame> getGameArtworkList() {
        return gameArtworkList;
    }

    public void setGameArtworkList(List<ArtworkInGame> gameArtworkList) {
        this.gameArtworkList = gameArtworkList;
    }
}

