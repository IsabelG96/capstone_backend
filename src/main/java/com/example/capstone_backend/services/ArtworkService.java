package com.example.capstone_backend.services;

import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.models.RarityLevel;
import com.example.capstone_backend.repositories.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.capstone_backend.models.RarityLevel.COMMON;

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

    public List<Artwork> generateRandomArtworkList() {

        List<Artwork> artworkList = new ArrayList<>();

        List <Artwork> allArtworks = artworkRepository.findAll();

        // rarity level filter common
        List<Artwork> commonArtworks = allArtworks.stream()
                .filter(artwork -> artwork.getRarityLevel() == RarityLevel.COMMON)
                .collect(Collectors.toList());

        // rarity level filter rare
        List<Artwork> rareArtworks = allArtworks.stream()
                .filter(artwork -> artwork.getRarityLevel() == RarityLevel.RARE)
                .collect(Collectors.toList());

        //rarity level filter legendary
        List<Artwork> legendaryArtworks = allArtworks.stream()
                .filter(artwork -> artwork.getRarityLevel() == RarityLevel.LEGENDARY)
                .collect(Collectors.toList());

        // Generate random common artworks
        List<Artwork> randomCommonArtworks = getRandomArtworkSubset(commonArtworks, 5);
        artworkList.addAll(randomCommonArtworks);

        // Generate random rare artworks
        List<Artwork> randomRareArtworks = getRandomArtworkSubset(rareArtworks, 3);
        artworkList.addAll(randomRareArtworks);

        // Generate random legendary artworks
        List<Artwork> randomLegendaryArtworks = getRandomArtworkSubset(legendaryArtworks, 2);
        artworkList.addAll(randomLegendaryArtworks);

        return artworkList;
    }

    private List<Artwork> getRandomArtworkSubset(List<Artwork> artworkList, int count) {
        List<Artwork> randomSubset = new ArrayList<>();
        Random random = new Random();

        if (count > artworkList.size()) {
            // Handle the case where count is greater than the available artworks
            count = artworkList.size();
        }

        while (randomSubset.size() < count) {
            int randomIndex = random.nextInt(artworkList.size());
            Artwork randomArtwork = artworkList.get(randomIndex);

            if (!randomSubset.contains(randomArtwork)) {
                randomSubset.add(randomArtwork);
            }
        }

        return randomSubset;
    }


//    public List<Artwork> generateRandomUniqueArtworks(int count) {
//        List<Artwork> randomArtworks = new ArrayList<>();
//        List<Artwork> allArtworks = artworkRepository.findAll();
//        int totalArtworkCount = allArtworks.size();
//
//        if (count > totalArtworkCount) {
//            // Handle the case where count is greater than the available artworks
//            count = totalArtworkCount;
//        }
//
//        Random random = new Random();
//        while (randomCommonArtworks.size() < 5) {
//            int randomIndex = random.nextInt(totalArtworkCount);
//            Artwork randomArtwork = allArtworks.get(randomIndex);
//            // Artwork randomArtwork = allArtworks.get(randomIndex);
//            if (!randomArtworks.contains(randomArtwork)
//                && randomArtworks.contains(randomArtwork.getRarityLevel().COMMON)) {
//                // if it doesn't contain random already
//                // AND if random id list artworks doesn't already include X number of artworks which are COMMON/ RARE
//                randomArtworks.add(randomArtwork);
//            }
//        }
//
//        return randomArtworks;
//    }
    //sort by rarity


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
