package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository {

    void createCustomerOrder(CustomerOrder order);

    List<CustomerOrder> getCustomerOrdersById(Integer id);

}
