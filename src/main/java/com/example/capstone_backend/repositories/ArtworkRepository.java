package com.example.capstone_backend.repositories;

import com.example.capstone_backend.models.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
}
