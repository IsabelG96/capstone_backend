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

//    Generate random artwork list with unique id (no repeat in artworks)
//    5 artworks with rarity level COMMON
//    3 artworks with rarity level RARE
//    2 artworks with rarity level LEGENDARY
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

//    Function to get a random id and check if its already been called
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
}
