package com.epam.pizza.domain;

/**
 * Created by dennis on 7/23/2015.
 */
public class Pizza {
    int id;
    String name;
    int price;
    public enum type {Vegetarian, Sea, Meat}
    type PizzaType;

    public Pizza(int id, String name,int price, type PizzaType){
        this.id = id;
        this.name = name;
        this.PizzaType = PizzaType;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", PizzaType=" + PizzaType +
                '}';
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

}
