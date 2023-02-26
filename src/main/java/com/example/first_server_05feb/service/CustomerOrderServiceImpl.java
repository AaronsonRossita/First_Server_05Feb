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
    @Autowired
    private CustomerService customerService;

    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest request) {
        if (request.getCustomer() != null){
            if (request.getCustomer().getId() != null){
                if (request.toCustomerOrder() != null){
                    if (customerService.getCustomerById(request.getCustomer().getId()) != null){
                        repository.createCustomerOrder(request.toCustomerOrder());
                    }else{
                        customerService.postCustomer(request.getCustomer());
                        repository.createCustomerOrder(request.toCustomerOrder());
                    }
                }else{
                    System.out.println("can't create order without order");
                }
            }else{
                System.out.println("can't create order without customer id");
            }
        }else{
            System.out.println("can't create order without customer");
        }
        return null;
    }
}
