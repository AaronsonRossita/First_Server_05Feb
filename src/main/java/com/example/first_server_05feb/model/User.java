package com.example.first_server_05feb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty(value = "user_id")
    private int id;
    private String name;
    private String email;
    @JsonProperty(value = "is_vip")
    private boolean isVip;

    public User(int id, String name, String email, boolean isVip) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isVip = isVip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    @Override
    public String toString() {
        return String.format("User id = %s with name = %s",id, name);
    }
}
