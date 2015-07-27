package com.epam.pizza.services;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;

/**
 * Created by dennis on 7/23/2015.
 */
public interface OrderService {
    public Order placeNewOrder(Customer customer, Integer ... pizzasID);
}
