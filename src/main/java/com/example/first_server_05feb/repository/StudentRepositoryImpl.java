package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static final String STUDENT_TABLE_NAME = "student";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createStudent(Student student) {
        String sql = String.format("INSERT INTO %s (first_name, last_name, email) VALUES (?,?,?)",STUDENT_TABLE_NAME);
        jdbcTemplate.update(sql,
                            student.getFirstName(),
                            student.getLastName(),
                            student.getEmail());
    }

    @Override
    public void deleteStudent(int id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?", STUDENT_TABLE_NAME);
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void updateStudent(Student student) {
        String sql = String.format("UPDATE %s SET first_name=?, last_name=?, email=? WHERE id=?",STUDENT_TABLE_NAME);
        jdbcTemplate.update(sql,
                            student.getFirstName(),
                            student.getLastName(),
                            student.getEmail(),
                            student.getId());
    }
}
