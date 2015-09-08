package com.trainee.pizza.web;

import com.trainee.pizza.services.AccumulativeCardService;
import com.trainee.pizza.services.CustomerService;
import com.trainee.pizza.services.PizzaOrderService;
import com.trainee.pizza.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;

/**
 * Created by dennis on 8/12/2015.
 */
public abstract class AbstractController {

    @Autowired
    protected PizzaService pizzaService;
    @Autowired
    protected PizzaOrderService pizzaOrderService;
    @Autowired
    protected CustomerService customerService;
    @Autowired
    protected AccumulativeCardService accumulativeCardService;

    protected abstract void pizzaBinder(WebDataBinder binder);

//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleIOException(Exception exception) {
//        ModelAndView modelAndView = new ModelAndView("/exception/catchedException");
//        modelAndView.addObject("message", exception.getMessage());
//        return modelAndView;
//    }
}
