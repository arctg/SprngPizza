package com.trainee.pizza.services.impl;

import com.trainee.pizza.domain.PizzaOrder;
import com.trainee.pizza.repository.PizzaOrderRepository;
import com.trainee.pizza.services.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dennis on 8/4/2015.
 */
@Service("pizzaOrderService")
public class PizzaOrderServiceImpl implements PizzaOrderService {


    @Autowired
    PizzaOrderRepository pizzaOrderRepository;

    @Transactional
    public void save(PizzaOrder pizzaOrder){
        pizzaOrderRepository.save(pizzaOrder);
    }

    public List<PizzaOrder> getPizzaOrdersByCustomerId(Integer id){
        return pizzaOrderRepository.getPizzaOrdersByCustomerId(id);
    }

    @Override
    public List<PizzaOrder> getAll() {
        return pizzaOrderRepository.getAll();
    }
}

