package com.example.capstone_backend.services;

import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.repositories.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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






}
