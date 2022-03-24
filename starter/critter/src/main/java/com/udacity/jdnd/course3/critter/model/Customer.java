package com.udacity.jdnd.course3.critter.model;

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



    @OneToOne(targetEntity = Pet.class)
    @JoinColumn(name="pet_id")
    private Pet pet;



    public Customer() {
    }

    public Customer(Long customerId, String name, String phoneNumber, String notes, Pet pet) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.pet = pet;
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

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }



}
