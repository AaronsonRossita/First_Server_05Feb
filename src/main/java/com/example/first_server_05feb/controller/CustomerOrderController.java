package com.example.first_server_05feb.controller;


import com.example.first_server_05feb.model.CustomerOrder;
import com.example.first_server_05feb.model.CustomerOrderRequest;
import com.example.first_server_05feb.model.CustomerOrderResponse;
import com.example.first_server_05feb.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/order")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService service;

    @PostMapping(value = "/create")
    public CustomerOrderResponse createOrder(@RequestBody CustomerOrderRequest request){
        return service.createCustomerOrder(request);
    }



}