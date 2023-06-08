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
            "Vincent van Gogh",
            "Sunflowers",
            5,
            RarityLevel.LEGENDARY,
            "url"
    );
    artworkRepository.save(artwork1);

    Artwork artwork2 = new Artwork(
            "Claude Monet",
            "Impression: Sunrise",
            6,
            RarityLevel.RARE,
            "url"
    );
    artworkRepository.save(artwork2);

    Artwork artwork3 = new Artwork(
            "Vincent van Gogh",
            "Starry Night",
            8,
            RarityLevel.COMMON,
            "url"
    );
    artworkRepository.save(artwork3);

    Artwork artwork4 = new Artwork(
            "Artemisia Gentileschi",
            "Judith Slaying Holofernes",
            8,
            RarityLevel.LEGENDARY,
            "url"
    );
    artworkRepository.save(artwork4);


    Artwork artwork5 = new Artwork(
            "Yayoi Kusama",
            "Pumpkin",
            5,
            RarityLevel.RARE,
            "url"
    );
    artworkRepository.save(artwork5);

    Artwork artwork6 = new Artwork(
            "George Stubbs",
            "Whistlejacket",
            4,
            RarityLevel.COMMON,
            "url"
    );
    artworkRepository.save(artwork6);

    Artwork artwork7 = new Artwork(
            "Frida Kahlo",
            "Self-Portrait with Monkey",
            7,
            RarityLevel.RARE,
            "url"
    );
    artworkRepository.save(artwork7);

    Artwork artwork8 = new Artwork(
            "Paul Cezanne",
            "The Basket of Apples",
            9,
            RarityLevel.COMMON,
            "url"
    );
    artworkRepository.save(artwork8);

    Artwork artwork9 = new Artwork(
            "Xu Bing",
            "A Book From The Sky",
            7,
            RarityLevel.RARE,
            "url"
    );
    artworkRepository.save(artwork9);

    Artwork artwork10 = new Artwork(
            "Frank Bowling",
            "Remember Thine Eyes",
            9,
            RarityLevel.RARE,
            "url"
    );
    artworkRepository.save(artwork10);

    Artwork artwork11 = new Artwork(
            "Carel Fabritius",
            "The Goldfinch",
            7,
            RarityLevel.RARE,
            "url"
    );
    artworkRepository.save(artwork11);

    Artwork artwork12 = new Artwork(
            "Johannes Vermeer",
            "Girl with the Pearl Earring",
            6,
            RarityLevel.COMMON,
            "url"
    );
    artworkRepository.save(artwork11);


    ArtworkInGame artworkInGame1 = new ArtworkInGame(game1, artwork1);
    artworkInGameRepository.save(artworkInGame1);

}










}
