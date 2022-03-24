package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {


    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerRepository customerRepository;

    private Customer customer;




    public PetService() {
    }

    public PetService(Customer customer) {
        this.customer = customer;
    }






    /* CREATE A PET FOR A NEWLY CREATED CUSTOMER */
    /* look for the created customer */
    public Customer findCustomer(Long id){
        return this.customer = this.customerRepository.findById(id).get();
    }

    public Pet createPet(Pet pet){
        pet.setCustomer(this.customer);
        return this.petRepository.save(pet);
    }



}
