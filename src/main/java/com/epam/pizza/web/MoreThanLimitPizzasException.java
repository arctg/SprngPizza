package com.epam.pizza.web;

import com.epam.pizza.domain.TotalOrderCostCalculator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dennis on 8/17/2015.
 */

@ResponseStatus(
        value = HttpStatus.NOT_ACCEPTABLE,
        reason = "There is more than max count of pizzas allowed " )
public class MoreThanLimitPizzasException extends RuntimeException {

    public MoreThanLimitPizzasException(String string) {
        super(string);
    }

}