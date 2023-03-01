package com.example.first_server_05feb.last_fm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastFmResponse {

    @JsonProperty(value = "toptracks")
    private LastFmTrackArray topTracks;

    public LastFmResponse() {
    }

    public LastFmResponse(LastFmTrackArray topTracks) {
        this.topTracks = topTracks;
    }

    public LastFmTrackArray getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(LastFmTrackArray topTracks) {
        this.topTracks = topTracks;
    }
}
