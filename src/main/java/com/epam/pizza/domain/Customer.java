package com.epam.pizza.domain;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "Customer.getAll", query = "select c from Customer c"),
        //Other named query
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Integer id;
    String name;
    @OneToOne
    @JoinColumn(name="card_id")
    private AccumulativeCard accumulativeCard;
//    @OneToOne
//    @JoinColumn(name="address_id")
//    private Address address;

    public Customer(){}

    public Customer(Integer id, String name, AccumulativeCard accumulativeCard){
        this.id = id;
        this.name = name;
        this.accumulativeCard = accumulativeCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccumulativeCard getAccumulativeCard() {
        return accumulativeCard;
    }

    public void setAccumulativeCard(AccumulativeCard accumulativeCard) {
        this.accumulativeCard = accumulativeCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

