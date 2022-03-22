package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name="availability")
    private Set<DayOfWeek> availability = new HashSet<>();

    public Customer() {
    }

    public Customer(Long customerId, String name, String phoneNumber, String notes, List<Pet> pets, Set<DayOfWeek> availability) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.pets = pets;
        this.availability = availability;
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

    public Set<DayOfWeek> getAvailability() {
        return availability;
    }

    public void setAvailability(Set<DayOfWeek> availability) {
        this.availability = availability;
    }
}
