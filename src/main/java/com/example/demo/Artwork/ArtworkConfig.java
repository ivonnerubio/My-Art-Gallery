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
                    "The Tower of Babel",
                    1563,
                    "Pieter Bruegel the Elder",
                    "https://arthistoryproject.com/site/assets/files/9971/pieter_bruegel_the_elder_-_the_tower_of_babel_1563_114x155cm_kunsthistorisches_museum_vienna-1.jpg"
            );

            Artwork nighthawks = new Artwork(
                    "Nighthawks",
                    1942,
                    "Edward Hopper",
                    "https://i.redd.it/1ofywg0vbrvz.jpg"
            );


            Artwork selfPortrait = new Artwork(
                    "Self-Portrait with Cropped Hair",
                    1940,
                    "Frida Kahlo",
                    "https://www.moma.org/media/W1siZiIsIjQ5NDA4NSJdLFsicCIsImNvbnZlcnQiLCItcXVhbGl0eSA5MCAtcmVzaXplIDIwMDB4MjAwMFx1MDAzZSJdXQ.jpg?sha=8e5f2e8b5844fd7b"
            );

            Artwork sleepingGypsy = new Artwork(
                    "The Sleeping Gypsy ",
                    1897,
                    "Henri Rousseau",
                    "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fuploads8.wikiart.org%2Fimages%2Fhenri-rousseau%2Fthe-sleeping-gypsy-1897.jpg&f=1&nofb=1"
            );



            repository.save(monaLisa);
            repository.save(nighthawks);
            repository.save(selfPortrait);
            repository.save(sleepingGypsy);
        };
    }
}
