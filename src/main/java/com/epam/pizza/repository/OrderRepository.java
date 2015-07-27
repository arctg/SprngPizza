package com.epam.pizza.repository;

import com.epam.pizza.domain.Order;

/**
 * Created by dennis on 7/23/2015.
 */
public interface OrderRepository {
    public abstract void saveOrder(Order order);
}
