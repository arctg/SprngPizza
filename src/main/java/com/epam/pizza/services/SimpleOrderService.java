package com.epam.pizza.services;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.domain.Pizza;
import com.epam.pizza.infrastructure.ApplicationContext;
import com.epam.pizza.infrastructure.Benchmark;
import com.epam.pizza.repository.OrderRepository;
import com.epam.pizza.repository.PizzaRepository;
import com.epam.pizza.repository.TestOrderRepository;
import com.epam.pizza.repository.TestPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
@Service
public class SimpleOrderService implements OrderService {

    //private ObjectFactory objectFactory = ObjectFactory.getInstance();

    private OrderRepository orderRepository = new TestOrderRepository();
    private PizzaRepository pizzaRepository = new TestPizzaRepository();
    //private ApplicationContext appContext;

    SimpleOrderService(){}
   @Autowired
    public SimpleOrderService(
            PizzaRepository pizzaRepository,
            OrderRepository orderRepository) throws Exception {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
//        pizzaRepository = (PizzaRepository)objectFactory.createObject("pizzaRepository");
//        orderRepository = (OrderRepository)objectFactory.createObject("orderRepository");
    }

    //@Required
    public void setPizzaRepository(PizzaRepository pizzaRepository){
        System.out.println("PizzaRepo test method");
        this.pizzaRepository = pizzaRepository;
    }


//    @Override
//    @Benchmark
    public Order placeNewOrder(Customer customer, Integer... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        for (Integer id : pizzasID) {
            pizzas.add(pizzaRepository.getPizzaById(id));  // get com.epam.pizza.domain.Pizza from predifined in-memory list
        }
        Order newOrder = new Order(customer,pizzas);
        orderRepository.saveOrder(newOrder);  // set com.epam.pizza.domain.Order Id and save com.epam.pizza.domain.Order to in-memory list
        return newOrder;
    }
@Lookup(value = "order")
    protected Order getNewOrder() {
        //Order newOrder = appContext.getBean("Order",Order.class);
        return null;
    }

//    public void setApplicationContext(ApplicationContext ac) {
//        this.appContext = ac;
//    }
}
