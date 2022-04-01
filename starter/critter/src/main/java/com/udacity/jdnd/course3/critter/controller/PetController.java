package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private Converter converter;



    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        PetDTO result = new PetDTO();
        System.out.println("Test source pet name : " + petDTO.getName());

        Pet petToSave = new Pet(petDTO.getId(), petDTO.getType(),petDTO.getName(),petDTO.getBirthDate(), petDTO.getNotes());
        try{
            Pet pet = this.converter.convertPetDTOToPet(petDTO);
            petToSave = this.petService.savePet(pet);
            result = this.converter.convertPetToPetDTO(petToSave);
        }catch(UnsupportedOperationException exception){
            exception.getLocalizedMessage();
        }
        return result;
    }


    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        PetDTO result = new PetDTO();
        System.out.println("Source ID  : " + petId);
        Pet pet = new Pet();
        try{
            pet = this.petService.findPetById(petId);
            result = this.converter.convertPetToPetDTO(pet);

        }catch(UnsupportedOperationException exception){
            exception.getLocalizedMessage();
        }
        return result;
    }



    @GetMapping
    public List<PetDTO> getPets(){
        throw new UnsupportedOperationException();
    }




    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId){
       List<PetDTO> petDTOS = new ArrayList<>();
       ArrayList<Pet> pets = new ArrayList<>();
       System.out.println("Test controller source owner ID : " + ownerId);
        try{
            pets = this.petService.findPetsByCustomerId(ownerId);

            petDTOS = this.converter.collectionConvertPetToPetDTO(pets);
            System.out.println(petDTOS.size());
        }catch(UnsupportedOperationException exception){
            exception.getLocalizedMessage();
        }catch (InvalidDataAccessApiUsageException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return petDTOS;
    }
}
