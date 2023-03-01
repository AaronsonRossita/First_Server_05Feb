package com.example.first_server_05feb.tv_maze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TvMazeController {

    @Autowired
    TvMazeService tvMazeService;

    @GetMapping(value = "/shows")
    TvMazeResponse getShowById(@RequestParam(value = "show_id") Integer id){
        return tvMazeService.getTvShowById(id);
    }

}
