package com.trainee.pizza.domain;

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
        @NamedQuery(name = "Customer.getCustomerIdByName", query = "select c.id from Customer c where name=:name")
        //Other named query
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;
    //    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection(fetch = FetchType.EAGER)
    //@ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Roles> roles;
    private Boolean blocked;
    @Column(unique = true)
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private AccumulativeCard accumulativeCard;
    private String password;
//    @OneToOne
//    @JoinColumn(name="address_id")
//    private Address address;

    public Customer() {
    }

    public Customer(Integer id, String name, AccumulativeCard accumulativeCard) {
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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public Boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", roles=" + roles +
                ", blocked=" + blocked +
                ", name='" + name + '\'' +
                ", accumulativeCard=" + accumulativeCard +
                '}';
    }
}

