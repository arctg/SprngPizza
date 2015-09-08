package com.trainee.pizza.domain;

import javax.persistence.*;

/**
 * Created by dennis on 7/23/2015.
 */
@Entity
@Table(name = "pizzas")
@NamedQueries({
        @NamedQuery(name = "Pizza.getAll", query = "select p from Pizza p"),
        //@NamedQuery(name = "Pizza.getById", query = "select p from Pizza p where id=?")
})
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name", length = 32)
    String name;
    @Column(name = "price")
    Integer price;
    @Enumerated(EnumType.STRING)
    PizzaType type;

    public Pizza() {
    }


    public Pizza(Integer id, String name, Integer price, PizzaType type) {
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

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public PizzaType getPizzaType() {
        return type;
    }

    public void setPizzaType(PizzaType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        if (!id.equals(pizza.id)) return false;
        if (!name.equals(pizza.name)) return false;
        if (!price.equals(pizza.price)) return false;
        return type == pizza.type;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
