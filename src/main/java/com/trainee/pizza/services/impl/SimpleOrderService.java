package com.trainee.pizza.services.impl;

import com.trainee.pizza.domain.Customer;
import com.trainee.pizza.domain.Order;
import com.trainee.pizza.domain.Pizza;
import com.trainee.pizza.repository.OrderRepository;
import com.trainee.pizza.repository.PizzaRepository;
import com.trainee.pizza.repository.impl.TestOrderRepository;
import com.trainee.pizza.repository.impl.TestPizzaRepository;
import com.trainee.pizza.services.OrderService;
import org.springframework.beans.factory.annotation.Lookup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
//@Service
public class SimpleOrderService implements OrderService {

    //private ObjectFactory objectFactory = ObjectFactory.getInstance();

    private OrderRepository orderRepository = new TestOrderRepository();
    private PizzaRepository pizzaRepository = new TestPizzaRepository();
    //private ApplicationContext appContext;

    SimpleOrderService() {
    }

//    @Autowired
    public SimpleOrderService(
            PizzaRepository pizzaRepository,
            OrderRepository orderRepository) throws Exception {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
//        pizzaRepository = (PizzaRepository)objectFactory.createObject("pizzaRepository");
//        orderRepository = (OrderRepository)objectFactory.createObject("orderRepository");
    }

    //@Required
    public void setPizzaRepository(PizzaRepository pizzaRepository) {
        System.out.println("PizzaRepo test method");
        this.pizzaRepository = pizzaRepository;
    }


    //    @Override
//    @Benchmark
    public Order placeNewOrder(Customer customer, Integer... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        for (Integer id : pizzasID) {
            pizzas.add(pizzaRepository.getPizzaById(id));  // get Pizza from predifined in-memory list
        }
        Order newOrder = new Order(customer, pizzas);
        orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list
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
