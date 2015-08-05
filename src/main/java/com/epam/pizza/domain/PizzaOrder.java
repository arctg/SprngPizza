package com.epam.pizza.domain;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by dennis on 8/4/2015.
 */
@Entity
public class PizzaOrder {
    @Id
    private int pizzaOrderId;
    @ElementCollection
    @CollectionTable(name="pizzascount")
    @MapKeyJoinColumn(name="PIZZA_ID")
    @Column(name="pizzas")
    private Map<Pizza,Integer> pizzas;
    @OneToOne
    @JoinColumn(name = "")
    private Address address;
}
