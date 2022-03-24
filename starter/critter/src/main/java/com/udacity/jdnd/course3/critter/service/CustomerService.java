package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public CustomerService() {
    }

    /* CREATE A NEW CUSTOMER */
    public Customer createCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    /* look for the created customer */
    public Customer findCustomer(Long id){
        return this.customerRepository.findById(id).get();
    }
}
