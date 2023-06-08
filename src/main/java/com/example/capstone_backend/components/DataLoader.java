package com.example.capstone_backend.components;

import com.example.capstone_backend.models.*;
import com.example.capstone_backend.repositories.ArtworkInGameRepository;
import com.example.capstone_backend.repositories.ArtworkRepository;
import com.example.capstone_backend.repositories.GameRepository;
import com.example.capstone_backend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

@Autowired ArtworkRepository artworkRepository;
@Autowired ArtworkInGameRepository artworkInGameRepository;
@Autowired PlayerRepository playerRepository;
@Autowired GameRepository gameRepository;


public DataLoader() {}
@Override
    public void run(ApplicationArguments args) throws Exception{

    Player player1 = new Player("Hayan");

    playerRepository.save(player1);

    Game game1 = new Game(player1);
    gameRepository.save(game1);

    Artwork artwork1 = new Artwork(
            "Vang Gough",
            "Sunflowers",
            5,
            RarityLevel.LEGENDARY,
            "url"
    );
    artworkRepository.save(artwork1);

    ArtworkInGame artworkInGame1 = new ArtworkInGame(game1, artwork1);
    artworkInGameRepository.save(artworkInGame1);

}










}
