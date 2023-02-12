package com.example.first_server_05feb.controller;

import com.example.first_server_05feb.model.Customer;
import com.example.first_server_05feb.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepositoryImpl repository;

    @PostMapping(value = "/customer/create")
    public void postCustomer(@RequestBody Customer customer){
        repository.postCustomer(customer);
    }

    @DeleteMapping(value = "/customer/delete")
    public void deleteCustomer (@RequestParam int id){
        repository.deleteCustomerById(id);
    }

    @PutMapping(value = "/customer/update")
    public void update (@RequestBody Customer customer){
        repository.updateCustomer(customer);
    }

}
