package com.trainee.pizza.infrastructure.impl;

import com.trainee.pizza.infrastructure.Config;
import com.trainee.pizza.repository.impl.TestOrderRepository;
import com.trainee.pizza.repository.impl.TestPizzaRepository;
import com.trainee.pizza.services.impl.SimpleOrderService;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by dennis on 7/23/2015.
 */
public class JavaConfig implements Config {

    private Map<String,Class<?>> map = new HashMap<>();

    {
        map.put("pizzaRepository", TestPizzaRepository.class);
        map.put("orderRepository", TestOrderRepository.class);
        map.put("orderService", SimpleOrderService.class);
    }


    public Class getImplementation(String beanName){
        return map.get(beanName);
    }
}
