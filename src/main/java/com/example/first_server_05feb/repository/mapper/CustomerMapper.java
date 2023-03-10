package com.example.first_server_05feb.repository.mapper;

import com.example.first_server_05feb.model.Customer;
import com.example.first_server_05feb.model.CustomerStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("This is the rowNum = " + rowNum);
        return new Customer(rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            CustomerStatus.valueOf(rs.getString("status")));
    }
}
