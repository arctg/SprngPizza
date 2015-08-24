package com.epam.pizza.repository;

import com.epam.pizza.domain.AccumulativeCard;

import java.util.List;

/**
 * Created by dennis on 8/24/2015.
 */
public interface AccumulativeCardRepository {
    public AccumulativeCard getAccumulativeCardById(Integer id);
    public List<AccumulativeCard> getAllAccumulativeCards();
    public Integer save(AccumulativeCard accumulativeCard);
    public void update(AccumulativeCard accumulativeCard);
    public void delete(Integer id);
}
