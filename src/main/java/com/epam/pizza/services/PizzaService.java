package com.epam.pizza.services;

import com.epam.pizza.domain.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by dennis on 8/4/2015.
 */
public class PizzaService {

    public EntityManager em = Persistence.createEntityManagerFactory("SprngPizza").createEntityManager();

    public Pizza add(Pizza pizza){
        em.getTransaction().begin();
        Pizza pizzaFromDB = em.merge(pizza);
        em.getTransaction().commit();
        return pizzaFromDB;
    }

    public void delete (int id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Pizza get(int id){
        return em.find(Pizza.class, id);
    }

    public void update(Pizza pizza){
        em.getTransaction().begin();
        em.merge(pizza);
        em.getTransaction().commit();
    }

    public List<Pizza> getAll(){
        TypedQuery<Pizza> namedQuery = em.createNamedQuery("Pizza.getAll",Pizza.class);
        return namedQuery.getResultList();
    }
}
