package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static final String STUDENT_TABLE_NAME = "student";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createStudent(Student student) {
        String sql = String.format("INSERT INTO %s (first_name, last_name, email, payment_method) VALUES (?,?,?,?)",STUDENT_TABLE_NAME);
        jdbcTemplate.update(sql,
                            student.getFirstName(),
                            student.getLastName(),
                            student.getEmail(),
                            student.getPaymentMethod().name());
    }

    @Override
    public void deleteStudent(int id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?", STUDENT_TABLE_NAME);
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void updateStudent(Student student) {
        String sql = String.format("UPDATE %s SET first_name=?, last_name=?, email=?, payment_method=?  WHERE id=?",STUDENT_TABLE_NAME);
        jdbcTemplate.update(sql,
                            student.getFirstName(),
                            student.getLastName(),
                            student.getEmail(),
                            student.getPaymentMethod().name(),
                            student.getId());
    }

    @Override
    public List<String> getStudentEmailByName(String name) {
        String sql = String.format("SELECT email FROM %s WHERE first_name=?",STUDENT_TABLE_NAME);
        try{
            System.out.println(jdbcTemplate.queryForList(sql, String.class, name));
            return jdbcTemplate.queryForList(sql, String.class, name);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Integer> getAllId() {
        String sql = String.format("SELECT id FROM %s",STUDENT_TABLE_NAME);
        try{
            return jdbcTemplate.queryForList(sql,Integer.class);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
