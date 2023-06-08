package com.example.capstone_backend.services;


import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.models.ArtworkInGame;
import com.example.capstone_backend.repositories.ArtworkInGameRepository;
import com.example.capstone_backend.repositories.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ArtworkInGameService {

    @Autowired
    ArtworkInGameRepository artworkInGameRepository;


    @Autowired
    ArtworkRepository artworkRepository;







    // get all artworks in game
    public List<ArtworkInGame> getAllArtworkInGame(){
        return artworkInGameRepository.findAll();
    }

    // get artwork by id
    public Optional<ArtworkInGame> getArtworkById(Long id){
        return artworkInGameRepository.findById(id);
    }



    // method that randomly generates 10 artwork from ArtworkRepository
    public Artwork getRandomArtwork(){
        Random randomId = new Random();
        Long random = randomId.nextLong(1, 6);
        return continentRepository.findById(random).get();
    }


}
