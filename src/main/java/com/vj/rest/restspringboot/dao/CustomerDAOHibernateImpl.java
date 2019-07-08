package com.vj.rest.restspringboot.dao;

import com.vj.rest.restspringboot.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        Session currentSession= entityManager.unwrap(Session.class);
        Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
        List<Customer> customers = theQuery.getResultList();

        //get hibernate current session
        //create the query
        //execute the query and get the result
        return customers;
    }

    @Override
    public Customer findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer theCustomer = currentSession.get(Customer.class, theId);
        return theCustomer;
    }

    @Override
    public void save(Customer customer) {
        Session curSession = entityManager.unwrap(Session.class);
        curSession.saveOrUpdate(customer);

    }

    @Override
    public void deleteById(int theId) {
        Session curSession = entityManager.unwrap(Session.class);
        Query query = curSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",theId);
        query.executeUpdate();

    }
}
