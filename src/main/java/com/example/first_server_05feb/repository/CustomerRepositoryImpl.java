package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate; // java data base connector

    @Override
    public void postCustomer(Customer customer) {
        String sql = String.format("INSERT INTO %s (first_name, last_name, email) VALUES (?,?,?)", CUSTOMER_TABLE_NAME);
        //String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " (first_name, last_name, email) VALUES ('a','aa','@@')";
        jdbcTemplate.update(sql,
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getEmail());
    }

    @Override
    public void deleteCustomerById(int id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?",CUSTOMER_TABLE_NAME);
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = String.format("UPDATE %s SET first_name = ?, last_name = ?, email = ? WHERE id = ?",CUSTOMER_TABLE_NAME);
        jdbcTemplate.update(sql,
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getEmail(),
                            customer.getId());
    }


}
