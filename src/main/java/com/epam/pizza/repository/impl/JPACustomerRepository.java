package com.epam.pizza.repository.impl;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by dennis on 8/7/2015.
 */
@Repository("customerRepository")
public class JPACustomerRepository implements CustomerRepository{

    @PersistenceContext(name = "HibernateMySQL")
    private EntityManager em;

    @Override
    public Customer getCustomerById(Integer id){
        return em.find(Customer.class,id);
    }

    @Override
    public List<Customer> getAllCustomers(){
        TypedQuery<Customer> query = em.createNamedQuery("Customer.getAll",Customer.class);
        return query.getResultList();
    }

    @Override
    public Integer save(Customer customer){
        em.persist(customer);
        return customer.getId();
    }
}