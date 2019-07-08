package com.vj.rest.restspringboot.controller;

import com.vj.rest.restspringboot.entity.Customer;
import com.vj.rest.restspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer cId = customerService.findById(customerId);
        if (cId==null){
            throw new RuntimeException("Customer not Found !");
        }
        return cId;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerService.save(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable int customerId){
        Customer cId = customerService.findById(customerId);
        if (cId==null){
            throw new RuntimeException("Customer not Found !");
        }
        customerService.deleteById(customerId);

    }




}
