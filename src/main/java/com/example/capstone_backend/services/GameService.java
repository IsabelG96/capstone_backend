package com.example.capstone_backend.services;


import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.models.ArtworkInGame;
import com.example.capstone_backend.models.Game;
import com.example.capstone_backend.models.Player;
import com.example.capstone_backend.repositories.ArtworkInGameRepository;
import com.example.capstone_backend.repositories.ArtworkRepository;
import com.example.capstone_backend.repositories.GameRepository;
import com.example.capstone_backend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }


    // get game by id
    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Game createBlankGame(Long playerId) {
        Game game = new Game(
                playerService.getPlayerById(playerId).get()
        );
        return gameRepository.save(game);
    }

    public Game startNewGame(Long playerId) {
//        create game object with random artworkInGame array (say 10 artworks) and the identified player (using id))
        // ArtworkInGame artworkInGame = artworkInGameService.getRandomArtworkList();
//       create game with playerId
        Game game1 = createBlankGame(playerId);
//        Game game1 = new Game(playerService.getPlayerById(playerId).get());
//        fetch 10 random Ids from artwork repo
//        create 10 artworkInGame objects with game id and 10 random artwork ids
        List<Artwork> randomArtworks = artworkService.generateRandomArtworkList();
        ArtworkInGame[] artworksForGame = new ArtworkInGame[randomArtworks.size()];

        for (int i = 0; i < randomArtworks.size(); i++) {
            Artwork artwork1 = randomArtworks.get(i);
            artworksForGame[i] = artworkInGameService.createNewArtworkInGame(game1, artwork1);
//            artworkInGameService.saveArtworkInGame(artworksForGame[i]);
        }
        artworkInGameService.getArtworksInGameForGame(game1);

        gameRepository.save(game1);
        return game1;
    }

    public List<Game> getAllGamesByPlayerId(Long playerId) {
        return gameRepository.findAllByPlayerId(playerId);
    }

    public List<Game> getAllGamesByPlayerIdAndComplete(Long playerId, Boolean complete) {
        return gameRepository.findAllByPlayerIdAndComplete(playerId, complete);
    }
    public List<Game> getAllGamesByComplete(Boolean complete) {
        return gameRepository.findAllByComplete(complete);
    }
    public Game updateGame(Game game, Long gameId) {
//        Find the game to update by ID
        Game gameToUpdate = gameRepository.findById(gameId).get();
//        Set all the game properties
        gameToUpdate.setScore(game.getScore());
        gameToUpdate.setComplete(game.getComplete());
        gameToUpdate.setPenalty(game.getPenalty());

        return gameRepository.save(game);
    }
}
