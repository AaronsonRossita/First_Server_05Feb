package com.example.first_server_05feb.service;

import com.example.first_server_05feb.model.CustomerOrder;
import com.example.first_server_05feb.model.CustomerOrderRequest;
import com.example.first_server_05feb.model.CustomerOrderResponse;

public interface CustomerOrderService {

    CustomerOrderResponse createCustomerOrder(CustomerOrderRequest request) throws Exception;

}
