package com.epam.pizza.services;

import com.epam.pizza.domain.Customer;

/**
 * Created by dennis on 8/5/2015.
 */
public interface CustomerService {
    Customer getCustomerById(Integer id);
}
