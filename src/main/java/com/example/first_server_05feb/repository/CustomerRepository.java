package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.Customer;

public interface CustomerRepository {

    void postCustomer(Customer customer);
    void deleteCustomerById(int id);
    void updateCustomer(Customer customer);

}
