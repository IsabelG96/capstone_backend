package com.example.capstone_backend.repositories;

import com.example.capstone_backend.models.ArtworkInGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtworkInGameRepository extends JpaRepository<ArtworkInGame, Long> {
    List<ArtworkInGame> findAllByGameId(Long game_id);

    List<ArtworkInGame> findAllByGameIdAndStolen(Long gameId, Boolean stolen);
}

