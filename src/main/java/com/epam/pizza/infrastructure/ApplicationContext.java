package com.epam.pizza.infrastructure;

/**
 * Created by dennis on 7/23/2015.
 */
public interface ApplicationContext {
    public Object getBean(String beanName) throws Exception;
}
