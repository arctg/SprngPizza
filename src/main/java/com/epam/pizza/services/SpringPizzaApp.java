package com.epam.pizza.services;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.domain.Pizza;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.epam.pizza.repository.PizzaRepository;

import java.util.List;

/**
 * Created by dennis on 7/24/2015.
 */
public class SpringPizzaApp {
    public static void main (String args []){
        ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryContext.xml");
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repositoryContext);

        PizzaRepository pizzaRepository = (PizzaRepository)appContext.getBean("pizzaRepository");
        System.out.println(pizzaRepository);
        String[] beans = appContext.getBeanDefinitionNames();
        for(String b:beans){
            System.out.println(b);
        }
        Customer customer = new Customer(1,"Bruce");
        Order order;
        OrderService orderService = (OrderService)appContext.getBean("simpleOrderService");
        order = orderService.placeNewOrder(customer, 1, 2, 3);
        System.out.println(order);
        System.out.println(appContext.getBean("Order", Order.class));
        System.out.println(appContext.getBean("Order", Order.class));
//        List<Pizza> pizzas = (List)appContext.getBean("pizzas");
//        System.out.println(pizzas);

                appContext.close();
        repositoryContext.close();
    }
}
