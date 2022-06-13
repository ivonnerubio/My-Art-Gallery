package com.example.demo.Artwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;

    public ArtworkService(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    @Autowired
    public List<Artwork> getArtworks(){
        return artworkRepository.findAll();
    }

    public void addNewArtwork(Artwork artwork) {
        Optional<Artwork> addedArtwork = artworkRepository.findArtworkByName(artwork.getName());

        if(addedArtwork.isPresent()) {
            throw new IllegalStateException("Artwork already in database.");
        }
        else if(artwork.getName().isEmpty()){
            throw new IllegalStateException("Artwork name is missing. Please add the name of the artwork.");
        }
        else if(artwork.getArtist().isEmpty()){
            throw new IllegalStateException("Artist name is missing. Please add the name of the artist.");
        }
        else if(artwork.getDate().equals(0)){
            throw new IllegalStateException("Year of creation is missing. Please add the year of creation.");
        }
        else if(artwork.getImage().equals("")){
            throw new IllegalStateException("Image URL is missing. Please add the image URL.");
        }
        else{
            artworkRepository.save(artwork);
            System.out.println("Artwork Added");

        }

    }

    public void deleteArtwork(Long artworkId) {
        boolean exists = artworkRepository.existsById(artworkId);
        if(!exists){
            throw new IllegalStateException("artwork with id " + artworkId + " does not exist");
        }
        artworkRepository.deleteById(artworkId);
    }

    @Transactional
    public void updateArtwork(Long artworkId, String name, String image, String artistName) {
        Artwork artwork = artworkRepository.findById(artworkId).orElseThrow(()-> new IllegalStateException("artwork with id " + artworkId + "does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(artwork.getName(),name)){
            Optional<Artwork> artworkOptional = artworkRepository.findArtworkByName(name);
            if(artworkOptional.isPresent()){
                throw new IllegalStateException("artwork name taken");
            }
            artwork.setName(name);
        }

        if(image != null && image.length() > 0 && !Objects.equals(artwork.getImage(),image)){
            artwork.setImage(image);
        }

        if(artistName != null && artistName.length() > 0 && !Objects.equals(artwork.getArtist(),artistName)){
            artwork.setArtist(artistName);
        }

    }

}