package com.epam.pizza.domain;

import java.util.Map;

/**
 * Created by dennis on 8/3/2015.
 */
public class TotalOrderCostCalculator {

    private int limit = 10; //max count of pizzas in one order
    private double discount = 0.3;

    public double calculateTotalOrderPrice(Map<Pizza, Integer> pizzas) {

        double summ = 0;

        int max = 0;

        if (pizzas.size() > limit || pizzas.size() < 0) {
            throw new IllegalArgumentException("There is more than 10 pizzas");
        } else {
            for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
                if (entry.getKey().getPrice()/100 > max) {
                    max = entry.getKey().getPrice()/100;
                }
                summ += entry.getKey().getPrice()/100 * entry.getValue().intValue();
            }
//            System.out.println("Total count of pizzas: " + count);
            if (getPizzasCount(pizzas) > 4) {
                summ = summ - discount * max; //discount formula
            }
            if (getPizzasCount(pizzas) > limit)
                throw new IllegalArgumentException("There is more than 10 pizzas in your order");
        }

        return summ;
    }

    public Integer getPizzasCount(Map<Pizza, Integer> pizzas) {
        int count = 0;
        for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
            count = count + entry.getValue().intValue();
        }
        return count;
    }

    public Integer getLimit() {
        return limit;
    }

}
