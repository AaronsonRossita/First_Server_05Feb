package com.example.first_server_05feb.repository;

import com.example.first_server_05feb.model.CustomerOrder;
import com.example.first_server_05feb.model.CustomerOrderResponse;

import java.util.List;

public interface CustomerOrderRepository {

    void createCustomerOrder(CustomerOrder order);
    void updateCustomerOrder(CustomerOrder order);
    CustomerOrder getOrderById(Integer id);
    void deleteOrderById(Integer id);
    void deleteAllCustomerOrders(Integer customerId);

    List<CustomerOrder> getCustomerOrdersById(Integer id);

}
