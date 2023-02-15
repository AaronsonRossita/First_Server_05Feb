package com.example.first_server_05feb.controller;

import com.example.first_server_05feb.model.Customer;
import com.example.first_server_05feb.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepositoryImpl repository;

    @PostMapping(value = "/customer/create")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "OK")
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

    @GetMapping(value = "/customer")
    public List<Customer> getAllCustomers(){
        return repository.getAllCustomers();
    }

    @GetMapping(value = "/customer", params = "name")
    public List<Customer> getCustomerById(@RequestParam String name){
        return repository.getCustomerByName(name);
    }

    @GetMapping(value = "/customer", params = "id")
    public Customer getCustomerById(@RequestParam int id){
        return repository.getCustomerById(id);
    }

}
