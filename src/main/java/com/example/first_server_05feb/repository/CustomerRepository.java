package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository {

    void postCustomer(Customer customer);
    void deleteCustomerById(int id);
    void updateCustomer(Customer customer);

    List<Customer> getAllCustomers();
    List<Customer> getCustomerByName(String name);
    Customer getCustomerById(int id);

}
