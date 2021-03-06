package com.udacity.jdnd.course3.critter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.critter.dto.Views;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="pet")
public class Pet {

    @JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pet_id")
    private Long petId;

    @JsonView(Views.Public.class)
    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private PetType type;

    @JsonView(Views.Public.class)
    @Column(name="name")
    private String name;

    @JsonView(Views.Public.class)
    @Column(name="birth_date" )
    private LocalDate birthDate;

    @JsonView(Views.Public.class)
    @Column(name="notes")
    private String notes;


    @JsonIgnoreProperties("pet")
    @JsonManagedReference
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ElementCollection
    @CollectionTable(name="available_days", joinColumns = @JoinColumn(name="pet_id"))
    @Column(name="pet_available_days")
    private Set<DayOfWeek> days = new HashSet<>();


    @OneToMany( mappedBy = "pet")
    @Column(name="pet_schedules")
    private List<Schedule> schedule = new ArrayList<>();



    public Pet() {
    }

    public Pet(Long petId, PetType type, String name, LocalDate birthDate, String notes) {
        this.petId = petId;
        this.type = type;
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
    }

    public Pet(Long petId, PetType type, String name, LocalDate birthDate, String notes, Customer customer){
        this.petId = petId;
        this.type = type;
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
        this.customer = customer;
    }
    public Pet(Long petId, PetType type, String name, LocalDate birthDate, String notes, Customer customer, Set<DayOfWeek> days, List<Schedule> schedule) {
        this.petId = petId;
        this.type = type;
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
        this.customer = customer;
        this.days = days;
        this.schedule = schedule;
    }



    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(Set<DayOfWeek> days) {
        this.days = days;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
}

