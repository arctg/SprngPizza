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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Integer getPizzaOrderId() {
        return pizzaOrderId;
    }

    public void setPizzaOrderId(Integer pizzaOrderId) {
        this.pizzaOrderId = pizzaOrderId;
    }

    public Map<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Map<Pizza, Integer> pizzas) {
        this.pizzas = pizzas;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "pizzaOrderId=" + pizzaOrderId +
                ", pizzas=" + pizzas +
                ", address=" + address +
                '}';
    }
}
