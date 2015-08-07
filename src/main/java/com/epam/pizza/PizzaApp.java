package com.epam.pizza;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.infrastructure.*;
import com.epam.pizza.infrastructure.impl.JavaConfig;
import com.epam.pizza.infrastructure.impl.JavaConfigApplicationContext;
import com.epam.pizza.services.OrderService;

/**
 * Created by dennis on 7/23/2015.
 */
public class PizzaApp {
    public static void main(String[] args) throws Exception{
        Customer customer = new Customer(1,"Bruce",null);
        Order order;

        //ObjectFactory objectFactory = ObjectFactory.getInstance();

        //OrderService orderService = new SimpleOrderService(null,null)
                //(SimpleOrderService)objectFactory.createObject("orderService");
        Config config = new JavaConfig();
        ApplicationContext context = new JavaConfigApplicationContext(config);
        OrderService orderService = (OrderService)context.getBean("orderService");
        order = orderService.placeNewOrder(customer, 1, 2, 3);
        //System.out.println(orderService);
        System.out.println(order);
    }
}
