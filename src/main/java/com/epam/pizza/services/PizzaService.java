package com.epam.pizza.services;

import com.epam.pizza.domain.Pizza;

import java.util.List;

/**
 * Created by dennis on 8/11/2015.
 */
public interface PizzaService {
    public Pizza getPizzaById(Integer id);
    public List<Pizza> getAllPizzas();
    public void save(Pizza pizza);
    public void update(Pizza pizza);
    public void delete(Integer id);
}
