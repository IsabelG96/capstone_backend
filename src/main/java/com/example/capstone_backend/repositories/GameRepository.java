package com.example.capstone_backend.repositories;

import com.example.capstone_backend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
