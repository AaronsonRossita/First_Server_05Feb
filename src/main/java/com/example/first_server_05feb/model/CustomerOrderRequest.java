package com.example.first_server_05feb.model;

public class CustomerOrderRequest {

    private Customer customer;
    private CustomerOrder order;

    public CustomerOrderRequest(Customer customer, CustomerOrder order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }

    public CustomerOrder toCustomerOrder(){
        return new CustomerOrder(
                this.order.getId(),
                this.customer.getId(),
                this.order.getItemName(),
                this.order.getPrice());
    }


}
