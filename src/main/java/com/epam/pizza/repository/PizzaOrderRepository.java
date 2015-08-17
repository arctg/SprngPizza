package com.epam.pizza.repository;

import com.epam.pizza.domain.PizzaOrder;

/**
 * Created by dennis on 8/13/2015.
 */
public interface PizzaOrderRepository {
    public Integer save(PizzaOrder pizzaOrder);
}
