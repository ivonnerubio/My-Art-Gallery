package com.example.demo.Artwork;

import javax.persistence.*;

@Entity
@Table
public class Artwork {
    @Id
    @SequenceGenerator(
            name = "artwork_sequence",
            sequenceName = "artwork_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artwork_sequence"
    )
    private Long id;
    private String name;
    private int date;
    private String artist;
    private String image;

    public Artwork() {
    }

    public Artwork(String name, int date, String artist, String image) {
        this.name = name;
        this.date = date;
        this.artist = artist;
        this.image = image;
    }

    public Artwork(Long id, String name, int date, String artist,String image) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.artist = artist;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", artist='" + artist + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
