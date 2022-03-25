package com.udacity.jdnd.course3.critter.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.dto.Views;
import org.hibernate.annotations.Nationalized;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="customer")
public class Customer {

    @JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @JsonView(Views.Public.class)
    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name="pet_id")
    private List<Long>petIds;



    public Customer() {
    }

    public Customer(Long customerId, String name, String phoneNumber, String notes, List<Long> petIds) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.petIds = petIds;
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

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}
