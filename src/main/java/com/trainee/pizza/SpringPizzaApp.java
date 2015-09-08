package com.trainee.pizza;

import com.trainee.pizza.domain.Customer;
import com.trainee.pizza.domain.Order;
import com.trainee.pizza.services.OrderService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.trainee.pizza.repository.PizzaRepository;

/**
 * Created by dennis on 7/24/2015.
 */
public class SpringPizzaApp {
    public static void main(String args[]) {
        ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryContext.xml");
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repositoryContext);

        PizzaRepository pizzaRepository = (PizzaRepository) appContext.getBean("pizzaRepository");
        System.out.println(pizzaRepository);
        String[] beans = appContext.getBeanDefinitionNames();
        System.out.println("Context start");
        for (String b : beans) {
            System.out.println(b);
        }
        System.out.println("Context end");
        Customer customer = new Customer(1, "Bruce",null);
        Order order;
        OrderService orderService = appContext.getBean(OrderService.class);
        order = orderService.placeNewOrder(customer, 1, 2, 3);
        System.out.println(order);
        //System.out.println(appContext.getBean("order", Order.class));
//        List<Pizza> pizzas = (List)appContext.getBean("pizzas");
//        System.out.println(pizzas);

        appContext.close();
        repositoryContext.close();
    }
}
