package com.epam.pizza.domain;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by dennis on 8/4/2015.
 */
@Entity
@Table(name = "pizzaorder")
@NamedQueries({
        @NamedQuery(name = "PizzaOrder.getAll", query = "select po from PizzaOrder po"),
        //Other named query
})
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer pizzaOrderId;
    @ElementCollection
    @CollectionTable(name="pizzas_and_count")
    @MapKeyJoinColumn(name="pizza_id")
    @Column(name="pizzas_count")
    private Map<Pizza,Integer> pizzas;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
