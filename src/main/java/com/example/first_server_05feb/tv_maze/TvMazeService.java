package com.example.first_server_05feb.tv_maze;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "tvmaze",
        url = "${tvmaze.url}"
)
public interface TvMazeService {

    @GetMapping(value = "/shows/{id}")
    TvMazeResponse getTvShowById(@PathVariable Integer id);

}
