package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service

public class PetService {


    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerRepository customerRepository;


   /* SAVE A PET */
    public Pet savePet(Pet pet){
        return this.petRepository.save(pet);
    }

    /* COUNT THE ENTITES */
    public long countPets(){
        return this.petRepository.count();
    }

    /* GET PET BY ID */
    public Pet findPetById(long id){
        System.out.println("Pet service layer id : " + id);
        return this.petRepository.findById(id).orElse(new Pet());
    }

    /* GET ALL THE PETS */
    public List<Pet> getAllPets(){
        return (List<Pet>) this.petRepository.findAll();
    }


    /* GET ALL PETS BY CUSTOMER ID */
    @Transactional
    public ArrayList<Pet>findPetsByCustomerId(Long customerId){
        ArrayList<Pet> result = new ArrayList<>();
        result = this.petRepository.findByCustomerId(customerId);
        return result;
    }





}
