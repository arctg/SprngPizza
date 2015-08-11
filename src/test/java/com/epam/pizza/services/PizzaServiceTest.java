package com.epam.pizza.services;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.PizzaType;
import com.epam.pizza.services.impl.PizzaServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dennis on 8/4/2015.
 */
public class PizzaServiceTest extends TestCase {

    PizzaServiceImpl service = new PizzaServiceImpl();

    @Test
    @Transactional
    public void testAdd() throws Exception {
        Pizza pizza1 = new Pizza();
        pizza1.setName("BeAHulk");
        pizza1.setPrice(700);
        pizza1.setPizzaType(PizzaType.MEAT);
        Pizza pizza = service.add(pizza1);
        System.out.println(pizza);

    }

    public void testDelete() throws Exception {

    }

    public void testGet() throws Exception {

    }

    public void testUpdate() throws Exception {

    }

    public void testGetAll() throws Exception {


    }
}