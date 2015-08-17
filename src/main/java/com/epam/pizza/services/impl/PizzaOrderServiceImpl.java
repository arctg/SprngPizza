package com.epam.pizza.services.impl;

import com.epam.pizza.domain.PizzaOrder;
import com.epam.pizza.repository.PizzaOrderRepository;
import com.epam.pizza.services.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dennis on 8/4/2015.
 */
@Service("pizzaOrderService")
public class PizzaOrderServiceImpl implements PizzaOrderService{


    @Autowired
    PizzaOrderRepository pizzaOrderRepository;

    @Transactional
    public void save(PizzaOrder pizzaOrder){
        pizzaOrderRepository.save(pizzaOrder);
    }

}
