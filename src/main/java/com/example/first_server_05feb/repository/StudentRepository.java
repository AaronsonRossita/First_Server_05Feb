package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Student;

import java.util.List;

public interface StudentRepository {

    void createStudent(Student student);
    void deleteStudent(int id);
    void updateStudent(Student student);
    //Student getStudentById(int id);

    List<String> getStudentEmailByName(String name);
    List<Integer> getAllId();

}
