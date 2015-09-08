package com.trainee.pizza;

import com.trainee.pizza.domain.Customer;
import com.trainee.pizza.domain.Order;
import com.trainee.pizza.infrastructure.Config;
import com.trainee.pizza.infrastructure.impl.JavaConfig;
import com.trainee.pizza.infrastructure.impl.JavaConfigApplicationContext;
import com.trainee.pizza.services.OrderService;
import com.trainee.pizza.infrastructure.ApplicationContext;

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
