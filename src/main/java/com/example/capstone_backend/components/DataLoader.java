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


//    Game game2 = new Game(player1);
//    game2.setComplete(true);
//    gameRepository.save(game2);
//
//    Player player2 = new Player("Kelly");
//    playerRepository.save(player2);
//
//    Game game3 = new Game(player2);
//    gameRepository.save(game3);






    Artwork artwork1 = new Artwork(
            "Vincent van Gogh",
            "Sunflowers",
            3,
            RarityLevel.LEGENDARY,
            "https://en.wikipedia.org/wiki/Sunflowers_%28Van_Gogh_series%29#/media/File:Vincent_Willem_van_Gogh_127.jpg"
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
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg/1513px-Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg?20121101035929"
    );
    artworkRepository.save(artwork3);


    Artwork artwork4 = new Artwork(
            "Artemisia Gentileschi",
            "Judith Slaying Holofernes",
            3,
            RarityLevel.LEGENDARY,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Artemisia_Gentileschi_-_Giuditta_decapita_Oloferne_-_Google_Art_Project-Adjust.jpg/1280px-Artemisia_Gentileschi_-_Giuditta_decapita_Oloferne_-_Google_Art_Project-Adjust.jpg"
    );
    artworkRepository.save(artwork4);


    Artwork artwork5 = new Artwork(
            "Yayoi Kusama",
            "Pumpkin",
            2,
            RarityLevel.RARE,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/%E8%8D%89%E9%96%93%E5%BD%8C%E7%94%9F_%E5%8D%97%E7%93%9C_%E7%A6%8F%E5%B2%A1%E7%BE%8E%E8%A1%93%E9%A4%A8.jpg/1599px-%E8%8D%89%E9%96%93%E5%BD%8C%E7%94%9F_%E5%8D%97%E7%93%9C_%E7%A6%8F%E5%B2%A1%E7%BE%8E%E8%A1%93%E9%A4%A8.jpg?20210825074228"
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
            "https://collectionapi.metmuseum.org/api/collection/v1/iiif/78218/1312141/restricted"
    );
    artworkRepository.save(artwork9);


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
            "https://en.wikipedia.org/wiki/The_Goldfinch_(painting)#/media/File:Fabritius-vink.jpg"
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










}
