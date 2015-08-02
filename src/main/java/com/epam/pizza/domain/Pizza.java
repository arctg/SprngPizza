package com.epam.pizza.domain;

/**
 * Created by dennis on 7/23/2015.
 */
public class Pizza {
    int id;
    String name;
    int price;
//    public enum type {Vegetarian, Sea, Meat}
    //type PizzaType;
    PizzaType type;

//    public Pizza(){
//        System.out.println("Hello");
//    }



    public Pizza(int id, String name,int price,  PizzaType type){
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", PizzaType=" + type.toString() +
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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public PizzaType getPizzaType() {
        return type;
    }

    public void setPizzaType(PizzaType type) {
        this.type = type;
    }

}
