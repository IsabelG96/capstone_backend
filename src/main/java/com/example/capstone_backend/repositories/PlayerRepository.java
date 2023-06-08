package com.example.capstone_backend.repositories;

import com.example.capstone_backend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
