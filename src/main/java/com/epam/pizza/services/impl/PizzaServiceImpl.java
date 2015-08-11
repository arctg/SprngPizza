package com.epam.pizza.services.impl;


import com.epam.pizza.domain.Pizza;
import com.epam.pizza.repository.PizzaRepository;
import com.epam.pizza.services.PizzaService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by dennis on 8/4/2015.
 */
@Service("pizzaService")
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza getPizzaById(Integer id){
        return pizzaRepository.getPizzaById(id);
    }

    public List<Pizza> getAllPizzas(){
        return pizzaRepository.getAllPizzas();
    }

    @Transactional
    public void save(Pizza pizza){
        pizzaRepository.save(pizza);
    }

    @Transactional
    public void update(Pizza pizza){
        pizzaRepository.update(pizza);
    }

    @Transactional
    public void delete(Integer id){
        pizzaRepository.delete(id);
    }

}
