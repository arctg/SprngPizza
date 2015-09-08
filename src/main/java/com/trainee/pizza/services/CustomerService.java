package com.trainee.pizza.services;

import com.trainee.pizza.domain.Customer;

import java.util.List;

/**
 * Created by dennis on 8/5/2015.
 */
public interface CustomerService {
    public Customer getCustomerById(Integer id);
    public List<Customer> getAll();
    public void save(Customer customer);
    public void update(Customer customer);
    public void delete(Integer id);
    public Integer getIdByName(String name);
}
