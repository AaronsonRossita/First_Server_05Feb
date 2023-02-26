package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository {

    @Autowired
     private JdbcTemplate jdbcTemplate;

    private static final String ORDER_TABLE = "customer_order";

    @Override
    public void createCustomerOrder(CustomerOrder order) {
        String sql = String.format("INSERT INTO %s (customer_id, item_name, price) VALUES (?,?,?)",ORDER_TABLE);
        jdbcTemplate.update(sql, order.getCustomerId(), order.getItemName(),order.getPrice());
    }
}
