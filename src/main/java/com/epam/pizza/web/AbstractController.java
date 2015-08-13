package com.epam.pizza.web;

import com.epam.pizza.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by dennis on 8/12/2015.
 */
public abstract class AbstractController {

    @Autowired
    protected PizzaService pizzaService;

    protected abstract void pizzaBinder(WebDataBinder binder);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleIOException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("/exception/catchedException");
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}