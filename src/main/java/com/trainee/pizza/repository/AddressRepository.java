package com.trainee.pizza.repository;

import com.trainee.pizza.domain.Address;

import java.util.List;

/**
 * Created by dennis on 8/6/2015.
 */
public interface AddressRepository {
    public Address getAddressById(Integer id);
    public List<Address>  getAllAddresses();
    public Integer save(Address address);
}
