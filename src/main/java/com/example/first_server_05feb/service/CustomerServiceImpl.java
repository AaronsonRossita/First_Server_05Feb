package com.example.first_server_05feb.service;

import com.example.first_server_05feb.model.Customer;
import com.example.first_server_05feb.model.CustomerStatus;
import com.example.first_server_05feb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    @Override
    public String postCustomer(Customer customer) {
        if (customer.getStatus() == CustomerStatus.VIP){
            if (repository.getCustomerByStatus(CustomerStatus.VIP).size() < 10){
                repository.postCustomer(customer);
                return "Customer created";
            }else{
                return "Customer not created, too many VIPs";
            }
        }else{
            repository.postCustomer(customer);
            return "Customer created";
        }
    }

    @Override
    public void deleteCustomerById(int id) {
        repository.deleteCustomerById(id);
    }

    @Override
    public String updateCustomer(Customer customer) {
        if (getCustomerById(customer.getId()).getStatus() == CustomerStatus.VIP){
            repository.updateCustomer(customer);
            return "updated";
        }else if(customer.getStatus() == CustomerStatus.VIP){
            if (repository.getCustomerByStatus(CustomerStatus.VIP).size() < 10){
                repository.updateCustomer(customer);
                return "updated";
            }else{
                return "can't become VIP";
            }
        }else{
            repository.updateCustomer(customer);
            return "updated";
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        return repository.getCustomerByName(name);
    }

    @Override
    public Customer getCustomerById(int id) {
        return repository.getCustomerById(id);
    }
}
