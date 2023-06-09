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



    // method that randomly generates 10 artwork from ArtworkRepository




//    public List<ArtworkInGame> generateRandomArtworkList(Game game){
//        Random randomId = new Random();
//
//        Long random1 = randomId.nextLong(1, 11);
//        Long random2 = randomId.nextLong(1, 11);
//// TODO: refactor into artwork and game service
//
////        Game game = gameRepository.findById(gameId).get();
//        // Artwork has artistName, title, value, rarityLevel, url, listOfArtworkInGame
//        Artwork artwork1 = artworkRepository.findById(random1).get();
//        Artwork artwork2 = artworkRepository.findById(random2).get();
//
//        ArtworkInGame artworkInGame1 = new ArtworkInGame(game, artwork1);
//        ArtworkInGame artworkInGame2 = new ArtworkInGame(game, artwork2);
//
//        artworkInGameRepository.save(artworkInGame1);
//        artworkInGameRepository.save(artworkInGame2);
////        artworkRepository.findByGameId(gameId);
//        List<ArtworkInGame> artworkList1 = Arrays.asList(artworkInGame1, artworkInGame2);
//        return artworkList1;
//
//    }

// generate artworkInGame object using the randomArtwork
    public ArtworkInGame createNewArtworkInGame(Game game, Artwork artwork){
//        Artwork artwork1 = artworkService.generateRandomArtwork();
        ArtworkInGame artworkInGame1 = new ArtworkInGame(game, artwork);
        artworkInGameRepository.save(artworkInGame1);
        return artworkInGame1;
    }

    public void createArtworksInGameForGame (Game game){
//        max 10 artworkInGame objects created per game id
//        for every artworkInGame object generate 1 random artwork
        List<Artwork> artworksForGame = artworkService.artworkForGame();

        for(int i = 0; i < artworksForGame.size(); i++){
            Artwork artwork = artworksForGame.get(i);
            ArtworkInGame artworkInGame = new ArtworkInGame(game, artwork);
            artworkInGameRepository.save(artworkInGame);
        }

    }

//    Get Artworks for game
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
}
