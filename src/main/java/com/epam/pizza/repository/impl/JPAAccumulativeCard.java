package com.epam.pizza.repository.impl;

import com.epam.pizza.domain.AccumulativeCard;
import com.epam.pizza.repository.AccumulativeCardRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by dennis on 8/24/2015.
 */
@Repository("accumulativeCardRepisitory")
public class JPAAccumulativeCard implements AccumulativeCardRepository {

    @PersistenceContext(name = "HibernateMySQL")
    private EntityManager em;

    @Override
    public AccumulativeCard getAccumulativeCardById(Integer id) {
        return em.find(AccumulativeCard.class, id);
    }

    @Override
    public List<AccumulativeCard> getAllAccumulativeCards() {
        TypedQuery<AccumulativeCard> query = em.createNamedQuery("AccumulativeCard.getAll", AccumulativeCard.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Integer save(AccumulativeCard accumulativeCard) {
        em.persist(accumulativeCard);
        return accumulativeCard.getId();
    }

    @Override
    @Transactional
    public void update(AccumulativeCard accumulativeCard) {
        em.merge(accumulativeCard);
    }

    @Override
    public void delete(Integer id) {

    }
}
