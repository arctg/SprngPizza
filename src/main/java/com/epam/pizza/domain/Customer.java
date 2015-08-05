package com.epam.pizza.domain;

/**
 * Created by dennis on 7/23/2015.
 */
public class Customer {
    int id;
    String name;
    AccumulativeCard accumulativeCard;

    public Customer(int id, String name, AccumulativeCard accumulativeCard){
        this.id = id;
        this.name = name;
        this.accumulativeCard = accumulativeCard;
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

