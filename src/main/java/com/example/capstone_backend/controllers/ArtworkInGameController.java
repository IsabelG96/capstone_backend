package com.example.capstone_backend.controllers;


import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.models.ArtworkInGame;
import com.example.capstone_backend.models.Player;
import com.example.capstone_backend.services.ArtworkInGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/artworksInGame")
public class ArtworkInGameController {


    @Autowired
    ArtworkInGameService artworkInGameService;

    @GetMapping
    public ResponseEntity<List<ArtworkInGame>> getAllArtworkInGame(@RequestParam (required = false, name = "game_id") Long gameId,
                                                                   @RequestParam (required = false, name = "stolen") Boolean stolen) {
//        returns only stolen ArtworkInGame from a particular game
        if(gameId != null && stolen != null) {
            return new ResponseEntity<>(artworkInGameService.getAllArtworkInGameByGameIdAndStolen(gameId, stolen), HttpStatus.OK);
        }
//        returns all ArtworkInGame in a particular game
        else if(gameId != null){
                return new ResponseEntity<>(artworkInGameService.getAllArtworkInGameByGameId(gameId), HttpStatus.OK);
        }
//        returns all ArtworkInGame objects
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

//    PATCH
    @PatchMapping(value = "/{id}")
    public ResponseEntity<ArtworkInGame> updateStolen(@PathVariable Long id, @RequestParam Boolean stolen ){
        return new ResponseEntity<>(artworkInGameService.updateArtworkInGame(id, stolen), HttpStatus.OK);
    }
}
