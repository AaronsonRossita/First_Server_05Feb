package com.example.first_server_05feb.last_fm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastFmTrack {

    private String name;
    private String url;
    @JsonProperty(value = "artist")
    private LastFmArtist artist;

    public LastFmTrack() {
    }

    public LastFmTrack(String name, String url, LastFmArtist artist) {
        this.name = name;
        this.url = url;
        this.artist = artist;
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

    public LastFmArtist getArtist() {
        return artist;
    }

    public void setArtist(LastFmArtist artist) {
        this.artist = artist;
    }
}

