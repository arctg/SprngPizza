package com.epam.pizza.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

/**
 * Created by dennis on 8/4/2015.
 */
@Entity
@Table(name = "pizzaorder")
@NamedQueries({
        @NamedQuery(name = "PizzaOrder.getAll", query = "select po from PizzaOrder po"),
        @NamedQuery(name = "PizzaOrder.getAllByCustomersId", query = "select po from PizzaOrder po where customerId=:id")
        //Other named query
})
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer pizzaOrderId;
    @Column(name = "order_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar orderDateTime;
    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="pizzas_and_count")
    @MapKeyJoinColumn(name="pizza_id")
    @Column(name="pizzas_count")
    private Map<Pizza,Integer> pizzas;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="done")
    private Boolean completed = false;
    @Column(name = "completion_datetime",insertable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar completionDateTime;
    @Column(name = "summ")
    private Long summ;


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

    public Calendar getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Calendar orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Calendar getCompletionDateTime() {
        return completionDateTime;
    }

    public void setCompletionDateTime(Calendar completionDateTime) {
        this.completionDateTime = completionDateTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Long getSumm() {
        return summ;
    }

    public void setSumm(Long summ) {
        this.summ = summ;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "pizzaOrderId=" + pizzaOrderId +
                ", pizzas=" + pizzas +
                ", address=" + address +
                ", customerId=" + customerId +
                ", completed=" + completed +
                '}';
    }
}
