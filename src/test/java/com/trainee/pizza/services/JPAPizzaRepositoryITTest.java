package com.trainee.pizza.services;

import com.trainee.pizza.domain.Pizza;
import com.trainee.pizza.domain.PizzaType;
import com.trainee.pizza.repository.PizzaRepository;
import com.trainee.pizza.templates.RepositoryTestsTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

/**
 * Created by dennis on 8/5/2015.
 */
public class JPAPizzaRepositoryITTest extends RepositoryTestsTemplate {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Test
    public void testAdd() throws Exception {
        Pizza pizza1 = new Pizza();
        pizza1.setName("BeAHulk");
        pizza1.setPrice(700);
        pizza1.setPizzaType(PizzaType.MEAT);
        Integer id = pizzaRepository.save(pizza1);
        System.out.println(id);

    }

    @Test
    public void testSaveMethod(){
        Pizza pizza = new Pizza();
        pizza.setName("Dog");
        pizza.setPrice(200);
        pizza.setPizzaType(PizzaType.MEAT);

        Integer id = pizzaRepository.save(pizza);
        System.out.println(id);

        assertNotNull(id);
    }
}
