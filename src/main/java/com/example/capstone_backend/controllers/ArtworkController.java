package com.example.capstone_backend.controllers;

import com.example.capstone_backend.models.Artwork;
import com.example.capstone_backend.models.Player;
import com.example.capstone_backend.services.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/artworks")
public class ArtworkController {

    @Autowired
    ArtworkService artworkService;



    @GetMapping
    public ResponseEntity<List<Artwork>> getAllArtwork() {
        List<Artwork> artwork =artworkService.getAllArtwork();
        return new ResponseEntity<>(artwork, HttpStatus.OK);
    }



}
