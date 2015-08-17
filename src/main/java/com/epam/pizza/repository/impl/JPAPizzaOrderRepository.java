package com.epam.pizza.repository.impl;

import com.epam.pizza.domain.PizzaOrder;
import com.epam.pizza.repository.PizzaOrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dennis on 8/14/2015.
 */
@Repository("pizzaOrderRepository")
public class JPAPizzaOrderRepository implements PizzaOrderRepository {

    @PersistenceContext(name = "HibernateMySQL")
    private EntityManager em;

    @Override
    public Integer save(PizzaOrder pizzaOrder){
        em.persist(pizzaOrder);
        return pizzaOrder.getPizzaOrderId();
    }

}
