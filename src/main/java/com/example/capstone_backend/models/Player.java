package com.example.capstone_backend.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Long id;

    private String name;

    private List<Game> games;

    private int highestScore;

    public Player(String name){
        this.name = name;
        this.games = new ArrayList<>();
        this.highestScore = 0;
    }

    public Player(){}

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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }
}







