package com.epam.pizza.repository;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Pizza;

import java.util.List;

/**
 * Created by dennis on 8/7/2015.
 */
public interface CustomerRepository {
    public Customer getCustomerById(Integer id);
    public List<Customer> getAllCustomers();
    public Integer save(Customer customer);
    public void update(Customer customer);
    public void delete(Integer id);
    public Integer getIdByName(String name);
}
