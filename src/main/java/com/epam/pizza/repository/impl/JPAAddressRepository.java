package com.epam.pizza.repository.impl;

import com.epam.pizza.domain.Address;
import com.epam.pizza.repository.AddressRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by dennis on 8/6/2015.
 */
@Repository("addressRepository")
public class JPAAddressRepository implements AddressRepository {

    @PersistenceContext(name = "HibernateMySQL")
    private EntityManager em;

    @Override
    public Address getAddressById(Integer id){
        return em.find(Address.class,id);
    }

    @Override
    public List<Address> getAllAddresses(){
        TypedQuery<Address> query = em.createNamedQuery("Address.getAll",Address.class);
        return query.getResultList();
    }

    @Override
    public Integer save(Address address){
        em.persist(address);
        return address.getId();
    }

}


