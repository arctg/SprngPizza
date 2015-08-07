package com.epam.pizza;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.PizzaType;
import com.epam.pizza.repository.PizzaRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dennis on 8/5/2015.
 */
public class AppJPARunner {
    public static void main(String args[]) {

        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("repositoryContext.xml");
        PizzaRepository pizzaRepository = appContext.getBean("pizzaRepository",PizzaRepository.class);


        Pizza pizza1 = new Pizza();
        pizza1.setName("BeAStupid");
        pizza1.setPrice(50);
        pizza1.setPizzaType(PizzaType.VEGETERIAN);
        Integer id = pizzaRepository.save(pizza1);
        System.out.println(id);

//        for(Pizza p:pizzaRepository.getAllPizzas()){
//            System.out.println(p);
//        }
    }
}
