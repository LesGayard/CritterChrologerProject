package com.udacity.jdnd.course3.critter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.dto.Views;
import org.hibernate.annotations.Nationalized;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="customer")
public class Customer {

    //@JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customerId;

    @JsonView(Views.Public.class)
    @Column(name="name", length=255)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    @Column(name="phone_number")
    private String phoneNumber;

    @JsonView(Views.Public.class)
    @Column(name="notes", length=255)
    private String notes;

    @JsonIgnoreProperties("customer")
    @JsonBackReference
    @OneToMany(targetEntity = Pet.class)
    @JoinColumn(name="pet_id")
    private List<Pet>petIds;



    public Customer() {
    }

    public Customer(Long customerId, String name, String phoneNumber, String notes) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

    public Customer(Long customerId, String name, String phoneNumber, String notes, List<Pet> petIds) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.petIds = petIds;
    }



    public Long getCustomerId() {
        return this.customerId;
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

    public List<Pet> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Pet> petIds) {
        this.petIds = petIds;
    }



    /* HELPER METHODS */
    /*public List<Customer> getcustomer(){
        return List.of(this.getcustomer().toArray(new Customer[0]));
    }*/
}
