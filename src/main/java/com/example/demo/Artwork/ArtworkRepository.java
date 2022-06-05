package com.example.demo.Artwork;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

    @Query("SELECT s FROM Artwork s WHERE s.name = ?1")
    Optional<Artwork> findArtworkByName(String name);
}
