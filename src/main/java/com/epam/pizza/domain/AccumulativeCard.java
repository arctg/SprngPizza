package com.epam.pizza.domain;

/**
 * Created by dennis on 8/4/2015.
 */
public class AccumulativeCard {

    private Integer id;

    private Address address;

    private Integer accumulatedSumm;

    public AccumulativeCard(){}

    public AccumulativeCard(Integer id, Address address, Integer accumulatedSumm) {
        this.id = id;
        this.address = address;
        this.accumulatedSumm = accumulatedSumm;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccumulatedSumm() {
        return accumulatedSumm;
    }

    public void setAccumulatedSumm(Integer accumulatedSumm) {
        this.accumulatedSumm = accumulatedSumm;
    }
}
