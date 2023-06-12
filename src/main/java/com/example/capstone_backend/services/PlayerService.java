package com.example.capstone_backend.services;

import com.example.capstone_backend.models.Player;
import com.example.capstone_backend.repositories.GameRepository;
import com.example.capstone_backend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;


//    READ
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    };

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }


//    CREATE
    public Player addNewPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

}
