package com.example.demo.Artwork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtworkConfig {

    @Bean
    CommandLineRunner commandLineRunner(ArtworkRepository repository){
        return args -> {
            Artwork monaLisa = new Artwork(
                    "Mona Lisa",
                    1534,
                    "Leonardo da Vinci",
                    "https://upload.wikimedia.org/wikipedia/commons/6/6a/Mona_Lisa.jpg"
            );

            Artwork selfPortrait = new Artwork(
                    "Self-Portrait with Cropped Hair",
                    1940,
                    "Frida Kahlo",
                    "https://www.moma.org/media/W1siZiIsIjQ5NDA4NSJdLFsicCIsImNvbnZlcnQiLCItcXVhbGl0eSA5MCAtcmVzaXplIDIwMDB4MjAwMFx1MDAzZSJdXQ.jpg?sha=8e5f2e8b5844fd7b"
            );

            repository.save(monaLisa);
            repository.save(selfPortrait);
        };
    }
}
