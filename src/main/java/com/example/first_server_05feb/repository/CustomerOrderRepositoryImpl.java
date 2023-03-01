package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.CustomerOrder;
import com.example.first_server_05feb.repository.mapper.CustomerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public void updateCustomerOrder(CustomerOrder order) {
        String sql = String.format("UPDATE %s SET item_name = ?, price = ? WHERE id = ?",ORDER_TABLE);
        jdbcTemplate.update(sql,
                            order.getItemName(),
                            order.getPrice(),
                            order.getId());
    }

    @Override
    public CustomerOrder getOrderById(Integer id) {
        String sql = String.format("SELECT * FROM %s WHERE id = ?", ORDER_TABLE);
        return jdbcTemplate.queryForObject(sql, new CustomerOrderMapper(),id);
    }

    @Override
    public void deleteOrderById(Integer id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?",ORDER_TABLE);
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void deleteAllCustomerOrders(Integer customerId) {
        String sql = String.format("DELETE FROM %s WHERE customer_id = ?",ORDER_TABLE);
        jdbcTemplate.update(sql,customerId);
    }

    @Override
    public List<CustomerOrder> getCustomerOrdersById(Integer id) {
        String sql = String.format("SELECT * FROM %s WHERE customer_id=?",ORDER_TABLE);
        return jdbcTemplate.query(sql,new CustomerOrderMapper(),id);
    }




}
