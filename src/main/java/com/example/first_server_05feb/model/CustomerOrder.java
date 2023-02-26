package com.example.first_server_05feb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerOrder {

    private int id;
    @JsonProperty(value = "customer_id")
    private int customerId;
    @JsonProperty(value = "item_name")
    private String itemName;
    private double price;

    public CustomerOrder(int id, int customerId, String itemName, double price) {
        this.id = id;
        this.customerId = customerId;
        this.itemName = itemName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CustomerOrderResponse toCustomerOrderResponse(Customer customer, List<CustomerOrder> orders){
        return new CustomerOrderResponse(customer, orders);
    }
}
