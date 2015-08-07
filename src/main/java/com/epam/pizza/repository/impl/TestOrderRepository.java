package com.epam.pizza.repository.impl;

import com.epam.pizza.domain.Order;
import com.epam.pizza.infrastructure.Benchmark;
import com.epam.pizza.repository.OrderRepository;
import org.springframework.stereotype.Repository;

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
