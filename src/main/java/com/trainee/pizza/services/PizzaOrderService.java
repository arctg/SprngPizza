package com.trainee.pizza.services;

import com.trainee.pizza.domain.PizzaOrder;

import java.util.List;

/**
 * Created by dennis on 8/14/2015.
 */
public interface PizzaOrderService {
    public void save(PizzaOrder pizzaOrder);
    public List<PizzaOrder> getPizzaOrdersByCustomerId(Integer id);
    public List<PizzaOrder> getAll();
}
