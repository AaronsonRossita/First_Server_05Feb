package com.example.first_server_05feb.last_fm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "lastfm",
        url = "${lastfm.url}"
)
public interface LastFmService {

    @GetMapping(value = "/")
    LastFmResponse getTopTracksByArtist(@RequestParam String method,
                                        @RequestParam String format,
                                        @RequestParam(value = "api_key") String apiKey,
                                        @RequestParam String artist);

}
