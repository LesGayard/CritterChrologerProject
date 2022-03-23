package com.udacity.jdnd.course3.critter.model;

import com.udacity.jdnd.course3.critter.model.Pet;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private Long customerId;

    @Column(name="name", length=255)
    @Nationalized
    private String name;

    @Column(name="phone_number", length=9)
    private String phoneNumber;

    @Column(name="notes", length=255)
    private String notes;

    @OneToMany(mappedBy="customer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();



    public Customer() {
    }

    public Customer(Long customerId, String name, String phoneNumber, String notes, List<Pet> pets) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.pets = pets;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    /* HELPER METHODS */
    public void addPet (Pet pet){
        this.pets.add(pet);
    }

    public void removePet(Pet pet){
        this.pets.remove(pet.getPetId());
    }

}
