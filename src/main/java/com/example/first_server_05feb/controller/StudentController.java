package com.example.first_server_05feb.controller;

import com.example.first_server_05feb.model.Student;
import com.example.first_server_05feb.repository.StudentRepositoryImpl;
import com.example.first_server_05feb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping(value = "/student/create")
    void createStudent(@RequestBody Student student){
        try{
            service.createStudent(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @PutMapping(value = "/student/update")
    void updateStudent(@RequestBody Student student){
        try{
            service.updateStudent(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @DeleteMapping(value = "/student/delete")
    void deleteStudent(@RequestParam int id){
        service.deleteStudent(id);
    }

//    @DeleteMapping(value = "/student/delete/{id}")
//    void deleteStudent(@PathVariable int id){
//        repository.deleteStudent(id);
//    }

    @GetMapping(value = "/student/email")
    List<String> getStudentEmailByName(@RequestParam String name){
        return service.getStudentEmailByName(name);
    }

    @GetMapping(value = "/student/id")
    List<Integer> getAllId(){
        return service.getAllId();
    }

}
