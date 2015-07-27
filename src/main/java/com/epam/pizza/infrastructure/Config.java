package com.epam.pizza.infrastructure;

/**
 * Created by dennis on 7/23/2015.
 */
public interface Config {
    Class getImplementation(String beanName);
}
