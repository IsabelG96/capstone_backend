package com.example.capstone_backend.repositories;

import com.example.capstone_backend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {


    List<Game> findAllByPlayerId(Long playerId);
    List<Game> findAllByPlayerIdAndComplete(Long playerId, Boolean complete);

//    List<Game> findAllByComplete(Boolean complete);
}
