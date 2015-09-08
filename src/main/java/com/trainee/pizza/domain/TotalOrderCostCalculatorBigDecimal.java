//package com.epam.pizza.domain;
//
//import MoreThanLimitPizzasException;
//
//import java.math.BigDecimal;
//import java.util.Map;
//
///**
// * Created by dennis on 8/25/2015.
// */
//public class TotalOrderCostCalculatorBigDecimal {
//
//    private Integer limit = 10; //max count of pizzas in one order
//    private BigDecimal discount = BigDecimal.valueOf(0.3).setScale(2);
//
//
//    public BigDecimal calculateTotalOrderPrice(Map<Pizza, Integer> pizzas) throws MoreThanLimitPizzasException{
//
//        BigDecimal summ=BigDecimal.ZERO;
//
//        BigDecimal max = BigDecimal.ZERO;
//
//        if (pizzas.size() > limit || pizzas.size() < 0) {
//            throw new MoreThanLimitPizzasException("There is more than 10 pizzas");
//        } else {
//            for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
//                if (entry.getKey().getPrice().compareTo(max)==1) {
//                    max = entry.getKey().getPrice();
//                }
//                //summ += entry.getKey().getPrice() * entry.getValue().intValue();
//                summ.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
//            }
////            System.out.println("Total count of pizzas: " + count);
//            if (getPizzasCount(pizzas) > 4) {
//                //summ = summ - discount * max; //discount formula
//                summ = summ.subtract(discount.multiply(max));
//            }
//            if (getPizzasCount(pizzas) > limit)
//                throw new MoreThanLimitPizzasException("There is more than 10 pizzas in your order");
//        }
//
//        return summ;
//    }
//
//    public Integer getPizzasCount(Map<Pizza, Integer> pizzas) {
//        int count = 0;
//        for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
//            count = count + entry.getValue().intValue();
//        }
//        return count;
//    }
//
//    public Integer getLimit() {
//        return limit;
//    }
//
//}
