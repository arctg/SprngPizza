package com.epam.pizza.domain;

/**
 * Created by dennis on 7/23/2015.
 */
public class Customer {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    String name;




    public Customer(int id, String name){
        this.id = id;
        this.name = name;
    }
}
