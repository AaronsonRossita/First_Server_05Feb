package com.example.first_server_05feb.controller;

import com.example.first_server_05feb.model.Customer;
import com.example.first_server_05feb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping(value = "/create")
//    @ResponseStatus(code = HttpStatus.CREATED, reason = "OK")
    public String postCustomer(@RequestBody Customer customer){
        return service.postCustomer(customer);
    }

    @DeleteMapping(value = "/delete")
    public void deleteCustomer (@RequestParam int id){
        service.deleteCustomerById(id);
    }

    @PutMapping(value = "/update")
    public void update (@RequestBody Customer customer){
        service.updateCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping(params = "name")
    public List<Customer> getCustomerById(@RequestParam String name){
        return service.getCustomerByName(name);
    }

    @GetMapping(params = "id")
    public Customer getCustomerById(@RequestParam int id){
        return service.getCustomerById(id);
    }

}
