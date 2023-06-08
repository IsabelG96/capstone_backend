package com.example.capstone_backend.repositories;

import com.example.capstone_backend.models.ArtworkInGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkInGameRepository extends JpaRepository<ArtworkInGame, Long> {
}
