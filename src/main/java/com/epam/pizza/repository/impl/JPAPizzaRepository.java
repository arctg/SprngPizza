package com.epam.pizza.repository.impl;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.repository.PizzaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by dennis on 8/5/2015.
 */
@Repository("pizzaRepository")
public class JPAPizzaRepository implements PizzaRepository {

    @PersistenceContext(name = "HibernateMySQL")
    private EntityManager em;

    @Override
    public Pizza getPizzaById(Integer id){
        return em.find(Pizza.class,id);
    }

    @Override
    public List<Pizza> getAllPizzas(){
        TypedQuery<Pizza> query = em.createNamedQuery("Pizza.getAll",Pizza.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public Integer save(Pizza pizza){
        em.persist(pizza);
        return pizza.getId();
    }


}
