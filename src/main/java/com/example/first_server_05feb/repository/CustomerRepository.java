package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Customer;
import com.example.first_server_05feb.model.CustomerStatus;

import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository {

    void postCustomer(Customer customer);
    void deleteCustomerById(Integer id);
    void updateCustomer(Customer customer);

    List<Customer> getAllCustomers();
    List<Customer> getCustomerByName(String name);
    Customer getCustomerById(Integer id);

    List<Customer> getCustomerByStatus(CustomerStatus status);

}
