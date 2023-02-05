package com.example.first_server_05feb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    //     localhost:8090/test
    @GetMapping(value = "/test") // endpoint
    public String testOne(){
        return "This endpoint is working!";
    }

    @GetMapping(value = "/test/{testId}")
    public String testTwo(@PathVariable int testId){
        return "You requested test with id " + testId;
    }

    @GetMapping(value = "/tests")
    public String testThree(@RequestParam int id){
        return "You requested test with id " + id;
    }

    @PostMapping(value = "/test/create")
    public String testFour(@RequestBody int id){
        return "You created a test with id " + id;
    }
}
