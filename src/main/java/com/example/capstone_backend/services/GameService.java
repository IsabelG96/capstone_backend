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

    public Game createBlankGame(Long playerId){
        Game game = new Game(
                playerService.getPlayerById(playerId).get()
        );
        return gameRepository.save(game);
    }
    public Game createNewGame(Long playerId){
//        create game object with random artworkInGame array (say 10 artworks) and the identified player (using id))
        // ArtworkInGame artworkInGame = artworkInGameService.getRandomArtworkList();
//       create game with playerId
        Game game1 = createBlankGame(playerId);
//        fetch 10 random Ids from artwork repo
//        create 10 artworkInGame objects with game id and 10 random artwork ids
        artworkInGameService.createNewArtworkInGame(game1);
//        get artworkInGame list by doing a get


//        List<ArtworkInGame> artworkInGame = artworkInGameService.generateRandomArtworkList(game1);
//
        game1.setGameArtworkList(artworkInGameService.findByGameId(game1.getId()));
//////        save the game
        gameRepository.save(game1);

////        return the game
        return game1;
    }















}
