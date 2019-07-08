package com.vj.rest.restspringboot.dao;

import com.vj.rest.restspringboot.entity.Customer;

import java.util.List;

public interface CustomerDAO {

     List<Customer> findAll();

     Customer findById(int theId);

     void save(Customer customer);

     void deleteById(int theId);



}
