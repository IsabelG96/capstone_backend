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

    //players for dataloader
    Player player1 = new Player("Hayan");

    Player player2 = new Player("Issy");

    Player player3 = new Player("Katie");

    Player player4 = new Player("Stella");

    Player player5 = new Player("Kelly");

    playerRepository.save(player1);
    playerRepository.save(player2);
    playerRepository.save(player3);
    playerRepository.save(player4);
    playerRepository.save(player5);

//games for dataloader
    Game game1 = new Game(player1);
    game1.setScore(12);
    game1.setComplete(true);

    gameRepository.save(game1);

    Game game2 = new Game(player2);
    game2.setScore(10);
    game2.setComplete(true);

    gameRepository.save(game2);

    Game game3 = new Game(player3);
    game3.setScore(8);
    game3.setComplete(true);

    gameRepository.save(game3);

    Game game4 = new Game(player4);
    game4.setScore(15);
    game4.setComplete(true);

    gameRepository.save(game4);

    Game game5 = new Game(player5);
    game5.setScore(5);
    game5.setComplete(true);

    gameRepository.save(game5);

    Game game6 = new Game(player1);
    game6.setScore(3);
    game6.setComplete(true);

    gameRepository.save(game6);


// artworks for game
    Artwork artwork1 = new Artwork(
            "Vincent van Gogh",
            "Sunflowers",
            3,
            RarityLevel.LEGENDARY,
            "https://www.vincentvangogh.org/images/paintings/sunflowers.jpg"
    );
    artworkRepository.save(artwork1);


    Artwork artwork2 = new Artwork(
            "Claude Monet",
            "Impression: Sunrise",
            1,
            RarityLevel.COMMON,
            "https://upload.wikimedia.org/wikipedia/commons/5/59/Monet_-_Impression%2C_Sunrise.jpg"
    );
    artworkRepository.save(artwork2);


    Artwork artwork3 = new Artwork(
            "Vincent van Gogh",
            "Starry Night",
            1,
            RarityLevel.COMMON,
            "https://www.vincentvangogh.org/images/paintings/the-starry-night.jpg"
    );
    artworkRepository.save(artwork3);

    Artwork artwork4 = new Artwork(
            "Artemisia Gentileschi",
            "Judith Slaying Holofernes",
            3,
            RarityLevel.LEGENDARY,
            "https://upload.wikimedia.org/wikipedia/commons/4/4e/Artemisia_Gentileschi_-_Judith_Beheading_Holofernes_-_WGA8563.jpg"
    );
    artworkRepository.save(artwork4);

    Artwork artwork5 = new Artwork(
            "Yayoi Kusama",
            "Pumpkin",
            2,
            RarityLevel.RARE,
            "https://p.potaufeu.asahi.com/02df-p/picture/27127618/67a56ee91448717e905788177b870377.jpg"
    );
    artworkRepository.save(artwork5);

    Artwork artwork6 = new Artwork(
            "George Stubbs",
            "Whistlejacket",
            1,
            RarityLevel.COMMON,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Whistlejacket_by_George_Stubbs_edit.jpg/640px-Whistlejacket_by_George_Stubbs_edit.jpg"
    );
    artworkRepository.save(artwork6);


    Artwork artwork7 = new Artwork(
            "Frida Kahlo",
            "Self-Portrait with Monkey",
            2,
            RarityLevel.RARE,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Mostra_di_Frida_Kahlo_al_Mudec_di_Milano_3_maggio_2018_%2810%29.jpg/930px-Mostra_di_Frida_Kahlo_al_Mudec_di_Milano_3_maggio_2018_%2810%29.jpg?20200329131850"
    );
    artworkRepository.save(artwork7);


    Artwork artwork8 = new Artwork(
            "Paul Cezanne",
            "Still Life with Apples",
            1,
            RarityLevel.COMMON,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Paul_C%C3%A9zanne_-_Still_Life_with_Apples_-_Google_Art_Project.jpg/1500px-Paul_C%C3%A9zanne_-_Still_Life_with_Apples_-_Google_Art_Project.jpg?20121009213323"
    );
    artworkRepository.save(artwork8);

    Artwork artwork9 = new Artwork(
            "Xu Bing",
            "A Book From The Sky",
            2,
            RarityLevel.RARE,
            "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452386414i/28497953.jpg"
    );
    artworkRepository.save(artwork9);
//"https://collectionapi.metmuseum.org/api/collection/v1/iiif/78218/1312141/restricted"

    Artwork artwork10 = new Artwork(
            "Frank Bowling",
            "Remember Thine Eyes",
            2,
            RarityLevel.RARE,
            "https://1.bp.blogspot.com/-9XRtvz04rjk/XVwmKZrvjiI/AAAAAAAAUls/IQuEAO89MDgfwAsIAdUyOjBWGK-LdrUQgCLcBGAs/s1600/IMG_20190820_150611.jpg"
    );
    artworkRepository.save(artwork10);

    Artwork artwork11 = new Artwork(
            "Carel Fabritius",
            "The Goldfinch",
            1,
            RarityLevel.COMMON,
            "https://www.mauritshuis.nl/media/h0kpo0fg/0605_repro.jpg?center=0.25931301636041137,0.77457098283931358&mode=crop&width=3840&rnd=132902566749100000&quality=70"
    );
    artworkRepository.save(artwork11);

    Artwork artwork12 = new Artwork(
            "Johannes Vermeer",
            "Girl with the Pearl Earring",
            1,
            RarityLevel.COMMON,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/1665_Girl_with_a_Pearl_Earring.jpg/1280px-1665_Girl_with_a_Pearl_Earring.jpg"
    );
    artworkRepository.save(artwork12);

}
//









}
