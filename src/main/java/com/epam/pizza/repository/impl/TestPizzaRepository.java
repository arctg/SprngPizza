package com.epam.pizza.repository.impl;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.infrastructure.Benchmark;
import com.epam.pizza.repository.PizzaRepository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dennis on 7/23/2015.
 */
public class TestPizzaRepository implements PizzaRepository {

    List<Pizza> pizzas;



    public void init (){
//        pizzas = Arrays.asList(
//                new Pizza(1, "Meat", 200, Pizza.type.Meat),
//                new Pizza(2, "Sea", 300, Pizza.type.Sea),
////                new Pizza(3, "Veg", 400,Pizza.type.Vegetarian));
//        this.pizzas=pizzas;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
@Benchmark
    public Pizza getPizzaById(Integer id){
        for(Pizza p:pizzas ){
            if (id==p.getId()){
                return p;
            }
        }
        return null;
    }

    public List<Pizza> getAllPizzas(){
        return null;
    }

    public Integer save(Pizza pizza){
        return null;
    }
}
