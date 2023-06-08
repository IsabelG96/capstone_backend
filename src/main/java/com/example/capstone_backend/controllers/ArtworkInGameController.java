package com.example.capstone_backend.controllers;


import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.models.ArtworkInGame;
import com.example.capstone_backend.models.Player;
import com.example.capstone_backend.services.ArtworkInGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/artworksInGame")
public class ArtworkInGameController {


    @Autowired
    ArtworkInGameService artworkInGameService;

    @GetMapping
    public ResponseEntity<List<ArtworkInGame>> getAllArtworkInGame() {
        List<ArtworkInGame> artworkInGames = artworkInGameService.getAllArtworkInGame();
        return new ResponseEntity<>(artworkInGames, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ArtworkInGame> getArtworkById(@PathVariable Long id) {
        Optional<ArtworkInGame> artworkInGame = artworkInGameService.getArtworkById(id);
        if (artworkInGame.isPresent()) {
            return new ResponseEntity<>(artworkInGame.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
