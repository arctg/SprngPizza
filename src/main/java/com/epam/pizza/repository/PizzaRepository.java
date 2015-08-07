package com.epam.pizza.repository;

import com.epam.pizza.domain.Pizza;

import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
public interface PizzaRepository {
    public Pizza getPizzaById(Integer id);
    public List<Pizza> getAllPizzas();
    public Integer save(Pizza pizza);
}
