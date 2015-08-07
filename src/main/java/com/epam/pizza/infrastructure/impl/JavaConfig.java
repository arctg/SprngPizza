package com.epam.pizza.infrastructure.impl;

import com.epam.pizza.infrastructure.Config;
import com.epam.pizza.repository.impl.TestOrderRepository;
import com.epam.pizza.repository.impl.TestPizzaRepository;
import com.epam.pizza.services.impl.SimpleOrderService;

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
