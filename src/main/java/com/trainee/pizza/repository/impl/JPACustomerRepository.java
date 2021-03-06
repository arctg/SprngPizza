package com.trainee.pizza.repository.impl;

import com.trainee.pizza.domain.Customer;
import com.trainee.pizza.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Integer save(Customer customer){
        em.persist(customer);
        return customer.getId();
    }

    @Override
    @Transactional
    public void update(Customer customer){
        System.out.println("Hello from update!");
        em.merge(customer);
    }

    @Override
    @Transactional
    public void delete (Integer id){
        em.remove(getCustomerById(id));
    }

    @Override
    public Integer getIdByName(String name){
        TypedQuery<Integer> query =
                em.createNamedQuery("Customer.getCustomerIdByName",Integer.class).setParameter("name",name);
        return query.getSingleResult();
    }
}
