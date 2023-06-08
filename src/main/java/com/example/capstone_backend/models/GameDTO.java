package com.example.capstone_backend.models;

import java.util.List;

public class GameDTO {

    private int penalty;
    private int score;
    private Boolean complete;
    private Long playerId;
    private List<Artwork> gameArtworkList;
    private List<Artwork> stolenArtwork;
}

