package com.example.first_server_05feb.controller;

import com.example.first_server_05feb.model.Student;
import com.example.first_server_05feb.repository.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentRepositoryImpl repository;

    @PostMapping(value = "/student/create")
    void createStudent(@RequestBody Student student){
        repository.createStudent(student);
    }

    @PutMapping(value = "/student/update")
    void updateStudent(@RequestBody Student student){
        repository.updateStudent(student);
    }

    @DeleteMapping(value = "/student/delete")
    void deleteStudent(@RequestParam int id){
        repository.deleteStudent(id);
    }

//    @DeleteMapping(value = "/student/delete/{id}")
//    void deleteStudent(@PathVariable int id){
//        repository.deleteStudent(id);
//    }

}
