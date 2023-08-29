package com.krajmark.cashmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BaseUser {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private Integer balance;

    public BaseUser() {
    }

    public BaseUser(Integer id, String username, String password, Integer balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
