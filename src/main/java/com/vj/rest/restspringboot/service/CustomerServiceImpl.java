package com.vj.rest.restspringboot.service;

import com.vj.rest.restspringboot.dao.CustomerDAO;
import com.vj.rest.restspringboot.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

   private CustomerDAO customerDAO;

   @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    @Transactional
    public Customer findById(int theId) {
        return customerDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
      customerDAO.save(customer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
       customerDAO.deleteById(theId);

    }
}
