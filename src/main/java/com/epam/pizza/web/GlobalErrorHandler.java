package com.epam.pizza.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dennis on 8/13/2015.
 */
@ControllerAdvice
public class GlobalErrorHandler {

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MoreThanLimitPizzasException.class)
    public ModelAndView exceptionHandler(
            Exception exception,
            HttpServletRequest req) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("ex", exception);
        model.addObject("st",Thread.currentThread().getStackTrace());
        model.addObject("url", req.getRequestURL());
        return model;
    }
}
