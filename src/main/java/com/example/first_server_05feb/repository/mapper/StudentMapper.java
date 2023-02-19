package com.example.first_server_05feb.repository.mapper;

import com.example.first_server_05feb.model.PaymentMethod;
import com.example.first_server_05feb.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                PaymentMethod.valueOf(rs.getString("payment_method")));
    }
}
