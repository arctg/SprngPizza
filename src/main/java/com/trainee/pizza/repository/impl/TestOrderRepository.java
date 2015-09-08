package com.trainee.pizza.repository.impl;

import com.trainee.pizza.domain.Order;
import com.trainee.pizza.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
//@Repository
public class TestOrderRepository implements OrderRepository {

    List<Order> orders = new ArrayList<Order>();
    public void saveOrder(Order newOrder){
        newOrder.setId(orders.size() + 1);
        orders.add(newOrder);
    }
}
