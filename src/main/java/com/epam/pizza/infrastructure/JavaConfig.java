package com.epam.pizza.infrastructure;

import com.epam.pizza.repository.TestOrderRepository;
import com.epam.pizza.repository.TestPizzaRepository;
import com.epam.pizza.services.SimpleOrderService;

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
