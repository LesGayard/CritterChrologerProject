package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.model.PetType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {

    /* SAVE PET */
    public Pet save(Pet pet);

    /* FIND PET BY ITS ID  == NATIVE */

    /* GET ALL PETS == NATIVE */

    /* GET ALL PETS BY OWNET ID */

    /* TEST CUSTOMED QUERY */
    @Query("SELECT type FROM Pet p WHERE p.type = :type")
    public Iterable<PetType>findTypes();

    @Query("SELECT p FROM Pet p WHERE p.customer = :customer_id ")
    public ArrayList<Pet> findByCustomerId(@Param("customer_id") Long id);

}
