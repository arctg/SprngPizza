package com.epam.pizza.domain;

import javax.persistence.*;

/**
 * Created by dennis on 7/23/2015.
 */
@Entity
@Table(name = "pizzas")
@NamedQuery(name="Pizza.getAll",query = "select p from Pizza p")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="name", length = 32)
    String name;
    @Column(name="price")
    int price;
    @Enumerated(EnumType.STRING)
    PizzaType type;

    public Pizza(){}



    public Pizza(int id, String name, int price,  PizzaType type){
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
