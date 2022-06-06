package com.example.demo.Artwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/artwork")
public class ArtworkController {

    private final ArtworkService artworkService;

    @Autowired
    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

//    @GetMapping("")
//    public List<Artwork> getArtworks(){
//        return artworkService.getArtworks();
//    }

    @PostMapping("")
    public void registerNewArtwork(@RequestParam Artwork artwork){
        artworkService.addNewArtwork(artwork);
    }

    @DeleteMapping("{artworkId}")
    public void deleteArtwork(@PathVariable("artworkId") Long artworkId){
        artworkService.deleteArtwork(artworkId);
    }

    @PatchMapping("{artworkId}")
    public void updateArtwork(
            @PathVariable("artworkId") Long artworkId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String url,
            @RequestParam(required = false) String artistName
            ){
        artworkService.updateArtwork(artworkId,name,url,artistName);
    }

}
