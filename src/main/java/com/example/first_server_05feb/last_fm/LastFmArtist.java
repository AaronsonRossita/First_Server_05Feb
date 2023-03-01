package com.example.first_server_05feb.last_fm;

public class LastFmArtist {

    private String name;
    private String url;

    public LastFmArtist() {
    }

    public LastFmArtist(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
