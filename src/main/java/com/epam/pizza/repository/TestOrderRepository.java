package com.epam.pizza.repository;

import com.epam.pizza.domain.Order;
import com.epam.pizza.infrastructure.Benchmark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
public class TestOrderRepository implements OrderRepository {

    List<Order> orders = new ArrayList<Order>();
@Benchmark
    public void saveOrder(Order newOrder){
        newOrder.setId(orders.size() + 1);
        orders.add(newOrder);
    }
}
