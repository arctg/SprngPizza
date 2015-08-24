package com.epam.pizza.services.impl;

import com.epam.pizza.domain.AccumulativeCard;
import com.epam.pizza.repository.AccumulativeCardRepository;
import com.epam.pizza.services.AccumulativeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dennis on 8/24/2015.
 */
@Service("accumulativeCardService")
public class AccumulativeCardServiceImpl implements AccumulativeCardService {

    @Autowired
    AccumulativeCardRepository accumulativeCardRepository;

    @Override
    public AccumulativeCard getAccumulativeCardById(Integer id) {
        return accumulativeCardRepository.getAccumulativeCardById(id);
    }

    @Override
    @Transactional
    public Integer save(AccumulativeCard accumulativeCard) {
        return accumulativeCardRepository.save(accumulativeCard);
    }

    @Override
    @Transactional
    public void update(AccumulativeCard accumulativeCard) {
        accumulativeCardRepository.update(accumulativeCard);
    }
}
