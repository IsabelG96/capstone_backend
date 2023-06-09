package com.example.capstone_backend.controllers;


import com.example.capstone_backend.models.Game;
import com.example.capstone_backend.models.Player;
import com.example.capstone_backend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;



//    @GetMapping
//    public ResponseEntity<List<Game>> getAllGames() {
//        List<Game> games = gameService.getAllGames();
//        return new ResponseEntity<>(games, HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<Game>> getAllIncompleteGamesForPlayer(@RequestParam (required = false, name = "player_id") Long playerId) {
//        if (playerId != null) {
//            return new ResponseEntity<>(gameService.getAllGamesByPlayerId(playerId), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<Game>> getAllIncompleteGamesForPlayer(@RequestParam (required = false, name = "complete") Boolean complete) {
//        if (complete != null) {
//            return new ResponseEntity<>(gameService.getAllGamesByComplete(complete), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllIncompleteGamesForPlayer(@RequestParam (required = false, name = "player_id") Long playerId,
                                                                     @RequestParam (required = false, name = "complete") Boolean complete) {
        if (playerId != null && complete != null) {
            return new ResponseEntity<>(gameService.getAllGamesByPlayerIdAndComplete(playerId, complete), HttpStatus.OK);
        }
        else if (playerId != null){
            return new ResponseEntity<>(gameService.getAllGamesByPlayerId(playerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Optional<Game> game = gameService.getGameById(id);
        if (game.isPresent()) {
            return new ResponseEntity<>(game.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }




    @PostMapping
    public ResponseEntity<Game> createNewGame(@RequestParam long playerId){
        Game game = gameService.startNewGame(playerId);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }


}
