package com.example.first_server_05feb.service;

import com.example.first_server_05feb.model.CustomerOrder;
import com.example.first_server_05feb.model.CustomerOrderRequest;
import com.example.first_server_05feb.model.CustomerOrderResponse;
import com.example.first_server_05feb.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    private CustomerOrderRepository repository;

    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest request) {

        repository.createCustomerOrder(request.getOrder());
        return null;
    }
}
