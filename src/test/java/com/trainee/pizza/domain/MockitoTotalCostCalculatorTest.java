package com.trainee.pizza.domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * Created by dennis on 8/25/2015.
 */
public class MockitoTotalCostCalculatorTest {

    TotalOrderCostCalculator mockedTotalOrderCostCalculator = mock(TotalOrderCostCalculator.class);


    @Test
    public void test(){
        Map<Pizza,Integer> map = new HashMap<>();
        int pizzaPrice = 200;
        map.put(new Pizza(1,"Margo",pizzaPrice,PizzaType.MEAT),1);
        mockedTotalOrderCostCalculator.calculateTotalOrderPrice(map);
        verify(mockedTotalOrderCostCalculator).calculateTotalOrderPrice(map);

    }
}
