package com.epam.pizza.services.impl;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Pizza;
import com.epam.pizza.repository.CustomerRepository;
import com.epam.pizza.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dennis on 8/23/2015.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerById(Integer id){
        return customerRepository.getCustomerById(id);
    }

    public List<Customer> getAll(){
        return customerRepository.getAllCustomers();
    }

    @Transactional
    public void save(Customer customer){
        customerRepository.save(customer);
    }

    @Transactional
    public void update(Customer customer){
        customerRepository.update(customer);
    }

    @Transactional
    public void delete(Integer id){
        customerRepository.delete(id);
    }

    public Integer getIdByName(String name){
        return customerRepository.getIdByName(name);
    }
}
