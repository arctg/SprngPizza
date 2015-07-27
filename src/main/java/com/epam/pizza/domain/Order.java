package com.epam.pizza.domain;

import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
public class Order {
    int id;
    List<Pizza> pizza;
    Customer customer;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order(Customer customer,List<Pizza> pizzas){
        this.customer=customer;
        this.pizza=pizzas;
    }

    @Override
    public String toString() {
        return "com.epam.pizza.domain.Order{" +
                "id=" + id +
                ", pizza=" + pizza +
                '}';
    }
}
