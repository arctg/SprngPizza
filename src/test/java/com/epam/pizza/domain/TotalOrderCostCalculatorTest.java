package com.epam.pizza.domain;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dennis on 8/3/2015.
 */

public class TotalOrderCostCalculatorTest {

//    @Test
//    public void testCalculateTotalOrderPrice__NonePizzas(){
//        Map<Pizza,Integer> map = new HashMap<>();
//        TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
//        calculator.calculateTotalOrderPrice(map);
//
//    }

    @Test
    public void testCalculateTotalOrderPrice__OnePizza(){
        Map<Pizza,Integer> map = new HashMap<>();
        int pizzaPrice = 200;
        map.put(new Pizza(1,"Margo",pizzaPrice,PizzaType.MEAT),1);

        int expectedPrice = 200;

        TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
        double price = calculator.calculateTotalOrderPrice(map);
        assertEquals(expectedPrice,price,0.5);
    }

    @Test
    public void testCalculateTotalOrderPrice__TwoPizzas(){
        Map<Pizza,Integer> map = new HashMap<>();
        int pizzaPrice = 200;
        map.put(new Pizza(1,"Margo",pizzaPrice,PizzaType.MEAT),1);

        pizzaPrice = 300;
        map.put(new Pizza(1,"Bull",pizzaPrice,PizzaType.SEA),1);

        int expectedPrice = 500;

        TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
        double price = calculator.calculateTotalOrderPrice(map);
        assertEquals(expectedPrice, price, 0.5);

    }

    @Test
    public void testCalculateTotalOrderPrice__TreePizzas(){
        Map<Pizza,Integer> map = new HashMap<>();
        int pizzaPrice = 200;
        map.put(new Pizza(1,"Margo",pizzaPrice,PizzaType.MEAT),1);

        pizzaPrice = 200;
        map.put(new Pizza(1,"Bull",pizzaPrice,PizzaType.SEA),2);

        int expectedPrice = 600;

        TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
        double price = calculator.calculateTotalOrderPrice(map);
        assertEquals(expectedPrice,price,0.5);
    }

    @Test
    public void testCalculateTotalOrderPrice__FourPizzas(){
        Map<Pizza,Integer> map = new HashMap<>();
        int pizzaPrice = 200;
        map.put(new Pizza(1,"Margo",pizzaPrice,PizzaType.MEAT),2);

        pizzaPrice = 400;
        map.put(new Pizza(1,"Bull",pizzaPrice,PizzaType.SEA),2);

        int expectedPrice = 1200;

        TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
        double price = calculator.calculateTotalOrderPrice(map);
        assertEquals(expectedPrice,price,0.5);
    }

    @Test
    public void testCalculateTotalOrderPrice__TenPizzas(){
        Map<Pizza,Integer> map = new HashMap<>();
        int pizzaPrice = 200;
        map.put(new Pizza(1,"Margo",pizzaPrice,PizzaType.MEAT),10);

        int expectedPrice = 1940;

        TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
        double price = calculator.calculateTotalOrderPrice(map);
        assertEquals(expectedPrice,price,0.5);

    }

    @Test
    public void testCalculateTotalOrderPrice__FivePizzas(){
        Map<Pizza,Integer> map = new HashMap<>();
        int pizzaPrice = 200;
        map.put(new Pizza(1,"Margo",pizzaPrice,PizzaType.MEAT),3);

        pizzaPrice = 100;
        map.put(new Pizza(1,"SeaSee",pizzaPrice,PizzaType.SEA),1);

        pizzaPrice = 50;
        map.put(new Pizza(1,"Down",pizzaPrice,PizzaType.VEGETERIAN),1);

        int expectedPrice = 690;

        TotalOrderCostCalculator calculator = new TotalOrderCostCalculator();
        double price = calculator.calculateTotalOrderPrice(map);
        assertEquals(expectedPrice,price,0.5);

    }

}