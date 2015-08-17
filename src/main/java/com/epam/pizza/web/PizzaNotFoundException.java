package com.epam.pizza.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dennis on 8/13/2015.
 */
@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Pizza not found")
public class PizzaNotFoundException extends RuntimeException {

    public PizzaNotFoundException(String string) {
        super(string);
    }

}
