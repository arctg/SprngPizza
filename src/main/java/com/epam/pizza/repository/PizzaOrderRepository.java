package com.epam.pizza.repository;

import com.epam.pizza.domain.PizzaOrder;

import java.util.List;

/**
 * Created by dennis on 8/13/2015.
 */
public interface PizzaOrderRepository {
    public Integer save(PizzaOrder pizzaOrder);
    public List<PizzaOrder> getPizzaOrdersByCustomerId(Integer id);
    public List<PizzaOrder> getAll();
}
