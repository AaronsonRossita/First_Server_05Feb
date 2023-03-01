package com.example.first_server_05feb.service;

import com.example.first_server_05feb.model.Customer;
import com.example.first_server_05feb.model.CustomerOrder;
import com.example.first_server_05feb.model.CustomerOrderRequest;
import com.example.first_server_05feb.model.CustomerOrderResponse;
import com.example.first_server_05feb.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    private CustomerOrderRepository repository;
    @Autowired
    private CustomerService customerService;

    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest request) throws Exception{
        if (request.getCustomer() != null){
            if (request.getCustomer().getId() != null){
                if (request.toCustomerOrder() != null){
                    if (customerService.getCustomerById(request.getCustomer().getId()) != null){
                        repository.createCustomerOrder(request.toCustomerOrder());
                    }else{
                        customerService.postCustomer(request.getCustomer());
                        repository.createCustomerOrder(request.toCustomerOrder());
                    }
                    Customer customer = customerService.getCustomerById(request.getCustomer().getId());
                    List<CustomerOrder> orders = repository.getCustomerOrdersById(customer.getId());
                    CustomerOrderResponse response = new CustomerOrderResponse(customer,orders);
                    return response;
                }else{
                    throw new Exception("can't create order without order");
                }
            }else{
                throw new Exception("can't create order without customer id");
            }
        }else{
            throw new Exception("can't create order without customer");
        }
    }
}
