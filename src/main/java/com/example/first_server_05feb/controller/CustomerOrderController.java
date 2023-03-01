package com.example.first_server_05feb.controller;


import com.example.first_server_05feb.model.CustomerOrder;
import com.example.first_server_05feb.model.CustomerOrderRequest;
import com.example.first_server_05feb.model.CustomerOrderResponse;
import com.example.first_server_05feb.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/order")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService service;

    @PostMapping(value = "/create")
    public CustomerOrderResponse createOrder(@RequestBody CustomerOrderRequest request) throws Exception{
        return service.createCustomerOrder(request);
    }

    @PutMapping(value = "/update")
    public CustomerOrderResponse updateOrder(@RequestBody CustomerOrder order){
        return service.updateCustomerOrder(order);
    }

    @GetMapping(value = "/id")
    public CustomerOrder getOrderById(@RequestParam Integer id){
        return service.getOrderById(id);
    }

    @DeleteMapping(value = "/delete", params = "id")
    public void deleteOrderById(@RequestParam Integer id){
        service.deleteOrderById(id);
    }

    @DeleteMapping(value = "/delete", params = "customer_id")
    public void deleteAllCustomerOrders(@RequestParam(value = "customer_id") Integer id){
        service.deleteAllCustomerOrders(id);
    }



}
