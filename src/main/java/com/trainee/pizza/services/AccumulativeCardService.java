package com.trainee.pizza.services;

import com.trainee.pizza.domain.AccumulativeCard;

/**
 * Created by dennis on 8/5/2015.
 */
public interface AccumulativeCardService {
    public AccumulativeCard getAccumulativeCardById(Integer id);
    public Integer save(AccumulativeCard accumulativeCard);
    public void update(AccumulativeCard accumulativeCard);
}
