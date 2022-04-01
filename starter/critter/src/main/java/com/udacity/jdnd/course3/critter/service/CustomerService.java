package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Customer;

import com.udacity.jdnd.course3.critter.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public CustomerService() {
    }

    /* CREATE A NEW CUSTOMER */


    /* SAVE A CUSTOMER */
    public Customer saveCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    /* look for the created customer */
    public Customer findCustomer(Long id){
        return this.customerRepository.findById(id).orElse(new Customer());
    }

    public ArrayList<Customer> findAllCustomers(){

        return (ArrayList<Customer>) this.customerRepository.findAll();
    }

   /* COUNT THE ENTITIES AVAILABLE */
    public long countCustomers(){
        return this.customerRepository.count();
    }



}
