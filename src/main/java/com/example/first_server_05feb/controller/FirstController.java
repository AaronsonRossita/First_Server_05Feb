package com.example.first_server_05feb.controller;
import com.example.first_server_05feb.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class FirstController {

    HashMap<Integer,User> users = new HashMap<>();
    ArrayList<String> list = new ArrayList();

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

//    @PostMapping(value = "/test/create_user")
//    public String testFive(@RequestBody String name){
//        list.add(name);
//        System.out.println(list);
//        return "user was created";
//    }

    @PostMapping(value = "/test/create_user")
    public String testFive(@RequestBody User user){
        users.put(user.getId(),user);
        System.out.println(users);
        return "user was created";
    }

    @DeleteMapping(value = "/test/delete_user")
    public void testSix(@RequestParam int id){
        if (users.containsKey(id)){
            users.remove(id);
            System.out.println(users);
        }
    }



}
