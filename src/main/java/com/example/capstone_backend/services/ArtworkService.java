package com.example.capstone_backend.services;

import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.repositories.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ArtworkService {

    @Autowired
    ArtworkRepository artworkRepository;

    // get all artworks
    public List<Artwork> getAllArtwork(){
        return artworkRepository.findAll();
    }

    // get artwork by id
    public Optional<Artwork> getArtworkById(Long id){
        return artworkRepository.findById(id);
    }

    public Artwork generateRandomArtwork(){
        Random randomId = new Random();

        Long random1 = randomId.nextLong(1, 11);
        Artwork randomArtwork = artworkRepository.findById(random1).get();
        return randomArtwork;
    }

    public List<Artwork> artworkForGame(){
//        generate 10 random art objects as list
        List<Artwork> list = new LinkedList<Artwork>();
        Artwork [] artworksForGame = list.toArray(new Artwork[10]);
        for(int i = 0; i < 10; i++){
            Artwork artwork = generateRandomArtwork();
//            artworksInGames[i] = new ArtworkInGame();
            artworksForGame[i]=new Artwork(artwork.getArtist(), artwork.getTitle(), artwork.getValue(), artwork.getRarityLevel(),artwork.getUrl());
        }
        System.out.println(list);
        return list;
    }




}
