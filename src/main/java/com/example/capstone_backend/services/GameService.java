package com.example.capstone_backend.services;


import com.example.capstone_backend.models.ArtworkInGame;
import com.example.capstone_backend.models.Game;
import com.example.capstone_backend.repositories.ArtworkInGameRepository;
import com.example.capstone_backend.repositories.ArtworkRepository;
import com.example.capstone_backend.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ArtworkInGameRepository artworkInGameRepository;

    @Autowired
    ArtworkInGameService artworkInGameService;

    @Autowired
    ArtworkRepository artworkRepository;

    @Autowired
    ArtworkService artworkService;


    @Autowired
    PlayerService playerService;


    // get all games

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }


    // get game by id
    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);
    }

    public Game createNewGame(Long playerId){
//
        List<ArtworkInGame> randomlySelectedArtworkForGame = continentRandomService.getRandomContinent();
        Game game = new Game(
                continent,
                playerService.getPlayerById(playerId).get()
        );
//        save the game
        gameRepository.save(game);
//        return a reply
        return new Reply(game.getScore(), game.maxScore(), game.getPenalty(), "How many countries can you name in " + continent.getName());

//   TODO: If we were to add a GameMode we would have to add GameMode as a class, pass it into the properties and constructor of Game, and in the GameController and GameServices we need to also have GameMode in the parameter
//   TODO: Also, in this method, we need to create a variable for gameMode and at the end, when returning and reply, use an if statement (for the mode)
    }















}
