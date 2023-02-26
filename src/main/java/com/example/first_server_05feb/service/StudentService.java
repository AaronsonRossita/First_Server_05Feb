package com.example.first_server_05feb.service;

import com.example.first_server_05feb.model.Student;
import java.util.List;

public interface StudentService {

    void createStudent(Student student) throws Exception;
    void deleteStudent(int id);
    void updateStudent(Student student) throws Exception;

    List<String> getStudentEmailByName(String name);
    List<Integer> getAllId();

}
