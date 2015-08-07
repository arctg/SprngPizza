package com.epam.pizza.domain;

import javax.persistence.*;

/**
 * Created by dennis on 8/4/2015.
 */
@Entity
@Table(name = "addresses")
@NamedQueries({
        @NamedQuery(name = "Address.getAll", query = "select a from Address a"),
        //Other named query
})
public class Address {
    @Id
    @Column(name = "address_id")
    private Integer id;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private String porch;

    public Address(){}

    public Address(int id, String city, String street, String building, String apartment, String porch) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.porch = porch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPorch() {
        return porch;
    }

    public void setPorch(String porch) {
        this.porch = porch;
    }
}
