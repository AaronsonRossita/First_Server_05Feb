package com.example.first_server_05feb.service;

import com.example.first_server_05feb.model.Customer;

import java.util.List;

public interface CustomerService {

    String postCustomer(Customer customer);
    void deleteCustomerById(int id);
    String updateCustomer(Customer customer);

    List<Customer> getAllCustomers();
    List<Customer> getCustomerByName(String name);
    Customer getCustomerById(int id);

}
