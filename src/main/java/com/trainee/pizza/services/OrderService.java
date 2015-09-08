package com.trainee.pizza.services;

import com.trainee.pizza.domain.Customer;
import com.trainee.pizza.domain.Order;

/**
 * Created by dennis on 7/23/2015.
 */
public interface OrderService {
    public Order placeNewOrder(Customer customer, Integer ... pizzasID);
}
