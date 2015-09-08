package com.trainee.pizza.repository.impl;

import com.trainee.pizza.domain.PizzaOrder;
import com.trainee.pizza.repository.PizzaOrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by dennis on 8/14/2015.
 */
@Repository("pizzaOrderRepository")
public class JPAPizzaOrderRepository implements PizzaOrderRepository {

    @PersistenceContext(name = "HibernateMySQL")
    private EntityManager em;

    @Override
    public Integer save(PizzaOrder pizzaOrder) {
        em.persist(pizzaOrder);
        return pizzaOrder.getPizzaOrderId();
    }

    @Override
    public List<PizzaOrder> getPizzaOrdersByCustomerId(Integer id) {
        TypedQuery<PizzaOrder> query =
                em.createNamedQuery("PizzaOrder.getAllByCustomersId", PizzaOrder.class).setParameter("id",id);
        return query.getResultList();
    }

    @Override
    public List<PizzaOrder> getAll() {
        TypedQuery<PizzaOrder> query =
                em.createNamedQuery("PizzaOrder.getAll", PizzaOrder.class);
        return query.getResultList();
    }
}
