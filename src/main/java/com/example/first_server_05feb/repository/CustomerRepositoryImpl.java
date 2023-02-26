package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Customer;
import com.example.first_server_05feb.model.CustomerStatus;
import com.example.first_server_05feb.model.Student;
import com.example.first_server_05feb.repository.mapper.CustomerMapper;
import com.example.first_server_05feb.repository.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate; // java data base connector

    @Override
    public void postCustomer(Customer customer) {
        String sql = String.format("INSERT INTO %s (first_name, last_name, email, status) VALUES (?,?,?,?)", CUSTOMER_TABLE_NAME);
        //String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " (first_name, last_name, email) VALUES ('a','aa','@@')";
        jdbcTemplate.update(sql,
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getEmail(),
                            customer.getStatus().name());
    }

    @Override
    public void deleteCustomerById(Integer id) {
        String sql = String.format("DELETE FROM %s WHERE id = ?",CUSTOMER_TABLE_NAME);
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = String.format("UPDATE %s SET first_name = ?, last_name = ?, email = ?, status = ? WHERE id = ?",CUSTOMER_TABLE_NAME);
        jdbcTemplate.update(sql,
                            customer.getFirstName(),
                            customer.getLastName(),
                            customer.getEmail(),
                            customer.getStatus().name(),
                            customer.getId());
    }


    @Override
    public List<Customer> getAllCustomers() {
        String sql = String.format("SELECT * FROM %s",CUSTOMER_TABLE_NAME);
        try{
            return jdbcTemplate.query(sql,new CustomerMapper());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        String sql = String.format("SELECT * FROM %s WHERE first_name = ?",CUSTOMER_TABLE_NAME);
        try{
            return jdbcTemplate.query(sql,new CustomerMapper(),name);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {
        String sql = String.format("SELECT * FROM %s WHERE id = ?",CUSTOMER_TABLE_NAME);
        try{
            Customer customer = jdbcTemplate.queryForObject(sql,new CustomerMapper(),id);
            return customer;
//        return jdbcTemplate.queryForObject(sql,new CustomerMapper(),id);
        }catch (EmptyResultDataAccessException e){
            System.out.println("No result");
            return null;
        }
    }

    @Override
    public List<Customer> getCustomerByStatus(CustomerStatus status) {
        String sql = String.format("SELECT * FROM %s WHERE status = ?",CUSTOMER_TABLE_NAME);
        try{
            return jdbcTemplate.query(sql,new CustomerMapper(),status.name());
        }catch(EmptyResultDataAccessException e){
            System.out.println("No customers with this status");
            return null;
        }
    }


}
