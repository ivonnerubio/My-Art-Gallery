package com.example.demo;

public class form {


    private long id;
    private String content;
    private String artist;
    private int date;
    private String url;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getDate() {
        return date;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}