package com.example.first_server_05feb.last_fm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastFmTrackArray {

    @JsonProperty(value = "track")
    private LastFmTrack[] tracks;

    public LastFmTrackArray() {
    }

    public LastFmTrackArray(LastFmTrack[] tracks) {
        this.tracks = tracks;
    }

    public LastFmTrack[] getTracks() {
        return tracks;
    }

    public void setTracks(LastFmTrack[] tracks) {
        this.tracks = tracks;
    }
}
