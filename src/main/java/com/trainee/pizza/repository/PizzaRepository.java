package com.trainee.pizza.repository;

import com.trainee.pizza.domain.Pizza;

import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
public interface PizzaRepository {
    public Pizza getPizzaById(Integer id);
    public List<Pizza> getAllPizzas();
    public Integer save(Pizza pizza);
    public void update(Pizza pizza);
    public void delete(Integer id);
}
