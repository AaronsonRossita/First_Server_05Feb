package com.example.first_server_05feb.repository.mapper;

import com.example.first_server_05feb.model.CustomerOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOrderMapper implements RowMapper<CustomerOrder> {
    @Override
    public CustomerOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerOrder(rs.getInt("id"),
                rs.getInt("customer_id"),
                rs.getString("item_name"),
                rs.getDouble("price"));
    }
}
