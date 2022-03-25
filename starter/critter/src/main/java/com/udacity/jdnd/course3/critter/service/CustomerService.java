package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Customer;

import com.udacity.jdnd.course3.critter.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public CustomerService() {
    }

    /* CREATE A NEW CUSTOMER */
   /* public Customer createCustomer( Customer customer){
        Customer customer1 = new Customer();
        customer1.setName(customer.getName());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setNotes(customer.getNotes());
        customer1.setPetIds(customer.getPetIds());
        return customer1;
    }*/

    /* SAVE A CUSTOMER */
    public Customer saveCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    /* look for the created customer */
    public Customer findCustomer(Long id){
        return this.customerRepository.findById(id).get();
    }

    public Iterable<Customer> findAllCustomers(){
        return this.customerRepository.findAll();
    }

    /* GET OWNER BY PET */

}
