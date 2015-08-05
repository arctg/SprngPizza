package com.epam.pizza.services;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.PizzaType;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by dennis on 8/4/2015.
 */
public class PizzaServiceTest extends TestCase {

    PizzaService service = new PizzaService();

    @Test
    public void testAdd() throws Exception {
        Pizza pizza1 = new Pizza();
        pizza1.setName("BeAStupid");
        pizza1.setPrice(70);
        pizza1.setPizzaType(PizzaType.VEGETERIAN);
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