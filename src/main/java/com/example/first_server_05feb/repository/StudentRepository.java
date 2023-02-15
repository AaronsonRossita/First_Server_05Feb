package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Student;

public interface StudentRepository {

    void createStudent(Student student);
    void deleteStudent(int id);
    void updateStudent(Student student);
    //Student getStudentById(int id);

}
