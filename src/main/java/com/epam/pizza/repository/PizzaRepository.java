package com.epam.pizza.repository;

import com.epam.pizza.domain.Pizza;

/**
 * Created by dennis on 7/23/2015.
 */
public interface PizzaRepository {
    public abstract Pizza getPizzaById(int id);
}
