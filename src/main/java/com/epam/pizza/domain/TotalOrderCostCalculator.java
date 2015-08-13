package com.epam.pizza.domain;

import java.util.Map;

/**
 * Created by dennis on 8/3/2015.
 */
public class TotalOrderCostCalculator {

    public double calculateTotalOrderPrice(Map<Pizza, Integer> pizzas) {
        double discount = 0.3;
        double summ = 0;
        int count = 0;
        int max = 0;
        if (pizzas.size() > 10 || pizzas.size() < 1) {
            throw new IllegalArgumentException();
        } else {
            for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
                if (entry.getKey().getPrice() > max) {
                    max = entry.getKey().getPrice();
                }
                count = count + entry.getValue().intValue();
                summ += entry.getKey().getPrice() * entry.getValue().intValue();
            }
//            System.out.println("Total count of pizzas: " + count);
            if (count > 4) {
                summ = summ - discount * max;
            }
            if (count>10) throw new IllegalArgumentException();
        }

        return summ;
    }


}
