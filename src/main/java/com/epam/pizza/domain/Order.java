package com.epam.pizza.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
@Component(value = "order")
@Scope(value = "prototype")
public class Order {
    int id;
    List<Pizza> pizza;
    Customer customer;
    private String name;
    static int count;


    Order(){}

    public List<Pizza> getPizza() {
        return pizza;
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizza = pizza;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void destroy(){
        System.out.println("Destroy");
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", pizza=" + pizza +
                ", customer=" + customer +
                ", name='" + name + '\'' +
                '}';
    }
}
