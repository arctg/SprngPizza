package com.epam.pizza.repository;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.infrastructure.Benchmark;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
public class TestPizzaRepository implements PizzaRepository {

    List<Pizza> pizzas;


    public void init (){
        pizzas = Arrays.asList(
                new Pizza(1, "Meat", 200, Pizza.type.Meat),
                new Pizza(2, "Sea", 300, Pizza.type.Sea),
                new Pizza(3, "Veg", 400,Pizza.type.Vegetarian));

    }

    public Pizza getPizzaById(int id){
        for(Pizza p:pizzas ){
            if (id==p.getId()){
                return p;
            }
        }
        return null;
    }
}
