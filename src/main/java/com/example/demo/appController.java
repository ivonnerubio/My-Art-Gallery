package com.example.demo;

import com.example.demo.Artwork.Artwork;
import com.example.demo.Artwork.ArtworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class appController {

    private final ArtworkService artworkService;

    public appController(ArtworkService artworkService) {
        this.artworkService = artworkService;

    }


    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new form());
        model.addAttribute("artworks", artworkService.getArtworks());
        return "mainPage";
    }

    @PostMapping("")
    public String greetingSubmit(@ModelAttribute form form, Model model) {
        Artwork newArtwork = new Artwork();
        newArtwork.setDate(form.getDate());
        newArtwork.setArtist(form.getArtist());
        newArtwork.setImage(form.getUrl());
        newArtwork.setName(form.getContent());
        artworkService.addNewArtwork(newArtwork);
        model.addAttribute("greeting", form);
        model.addAttribute("artworks", artworkService.getArtworks());
        return "mainPage";
    }

    String getMainPage(Model model){
        model.addAttribute("hello", "this is coming from the controller");
        model.addAttribute("artworks", artworkService.getArtworks());
        return "mainPage";
    }
}
