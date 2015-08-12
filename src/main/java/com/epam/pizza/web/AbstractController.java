package com.epam.pizza.web;

import com.epam.pizza.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;

/**
 * Created by dennis on 8/12/2015.
 */
public abstract class AbstractController {

    @Autowired
    protected PizzaService pizzaService;

    protected abstract void pizzaBinder(WebDataBinder binder);
}
