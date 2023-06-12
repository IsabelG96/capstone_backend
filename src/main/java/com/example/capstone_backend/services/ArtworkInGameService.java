package com.example.capstone_backend.services;


import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.models.ArtworkInGame;
import com.example.capstone_backend.models.Game;
import com.example.capstone_backend.repositories.ArtworkInGameRepository;
import com.example.capstone_backend.repositories.ArtworkRepository;
import com.example.capstone_backend.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArtworkInGameService {

    @Autowired
    ArtworkInGameRepository artworkInGameRepository;

    @Autowired
    ArtworkRepository artworkRepository;

    @Autowired
    ArtworkService artworkService;

    @Autowired
    GameRepository gameRepository;


    // get all artworks in game
    public List<ArtworkInGame> getAllArtworkInGame(){
        return artworkInGameRepository.findAll();
    }

    // get artwork by id
    public Optional<ArtworkInGame> getArtworkById(Long id){
        return artworkInGameRepository.findById(id);
    }

    public ArtworkInGame createNewArtworkInGame(Game game, Artwork artwork){
//        Artwork artwork1 = artworkService.generateRandomArtwork();
        ArtworkInGame artworkInGame1 = new ArtworkInGame(game, artwork);
        artworkInGameRepository.save(artworkInGame1);
        return artworkInGame1;
    }

//    Get Artworks for particular game
    public List<ArtworkInGame> getArtworksInGameForGame(Game game){
//        search repository for artworkInGame objects matching gameId
        List<ArtworkInGame> artworksInGame = findAllByGameId(game.getId());
//       set artworksInGame as the found list
        game.setGameArtworkList(artworksInGame);
        return game.getGameArtworkList();
    }
    public List<ArtworkInGame> findAllByGameId(Long gameId){

        List<ArtworkInGame> artworkInGame = artworkInGameRepository.findAllByGameId(gameId);
        return artworkInGame;
    }

    public ArtworkInGame updateArtworkInGame(Long id, Boolean stolen) {
        ArtworkInGame stolenArtworkInGame = getArtworkById(id).get();
        stolenArtworkInGame.setStolen(stolen);
        return artworkInGameRepository.save(stolenArtworkInGame);
    }

    public List<ArtworkInGame> getAllArtworkInGameByGameId(Long gameId) {
        return artworkInGameRepository.findAllByGameId(gameId);
    }

    public List<ArtworkInGame> getAllArtworkInGameByGameIdAndStolen(Long gameId, Boolean stolen) {
        return artworkInGameRepository.findAllByGameIdAndStolen(gameId, stolen);
    }
}
