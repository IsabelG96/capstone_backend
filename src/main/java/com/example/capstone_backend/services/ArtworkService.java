package com.example.capstone_backend.services;

import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.repositories.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<Long> generateRandomUniqueIds(int count) {
        List<Long> randomIds = new ArrayList<>();
        List<Artwork> allArtworks = artworkRepository.findAll();
        int totalArtworkCount = allArtworks.size();

        if (count > totalArtworkCount) {
            // Handle the case where count is greater than the available artworks
            count = totalArtworkCount;
        }

        Random random = new Random();
        while (randomIds.size() < count) {
            int randomIndex = random.nextInt(totalArtworkCount);
            Long randomId = allArtworks.get(randomIndex).getId();

            if (!randomIds.contains(randomId)) {
                randomIds.add(randomId);
            }
        }

        return randomIds;
    }

    public List<Artwork> artworkForGame(){
//        generate 10 random art objects as list
        List<Artwork> randomArt = new LinkedList<Artwork>();
        Artwork [] artworksForGame = randomArt.toArray(new Artwork[10]);
        for(int i = 0; i < 10; i++){
            Artwork artwork = randomArt.get(i);
//            artworksInGames[i] = new ArtworkInGame();
            artworksForGame[i]=new Artwork(artwork.getArtist(), artwork.getTitle(), artwork.getValue(), artwork.getRarityLevel(),artwork.getUrl());
        }
        System.out.println(randomArt);
        return randomArt;
    }




}
