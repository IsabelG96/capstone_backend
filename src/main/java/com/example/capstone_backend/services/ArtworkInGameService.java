package com.example.capstone_backend.services;


import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.models.ArtworkInGame;
import com.example.capstone_backend.repositories.ArtworkInGameRepository;
import com.example.capstone_backend.repositories.ArtworkRepository;
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
        Long random1 = randomId.nextLong(1, 11);
        Long random2 = randomId.nextLong(1, 11);

        List<ArtworkInGame> listOfArtwork = new ArrayList<>();
//        Artwork artwork1 = artworkRepository.findById(random1).get();
//
//        Artwork artwork2 = artworkRepository.findById(random2).get();
        listOfArtwork.add(random1);
        listOfArtwork.setArtwork(Arrays.asList(artwork1, artwork2));

        return null;







    }


}
