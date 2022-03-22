package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.schedule.Availability;
import com.udacity.jdnd.course3.critter.schedule.Schedule;
import com.udacity.jdnd.course3.critter.user.Customer;

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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pet_id")
    private Long petId;

    @Column(name="type")
    private PetType type;

    @Column(name="name")
    private String name;

    @Column(name="birth_date" )
    private LocalDate birthDate;

    @Column(name="notes")
    private String notes;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_customer_id")
    private Customer customer;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "pet_schedule",
            joinColumns = @JoinColumn(name = "pet_pet_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_schedule_id"))
    private Schedule schedule;

    @OneToMany(mappedBy = "pet")
    private Set<Availability>available = new HashSet<>();


    public Pet() {
    }

    public Pet(Long petId, PetType type, String name, LocalDate birthDate, String notes, Customer customer, Schedule schedule, Set<Availability> available) {
        this.petId = petId;
        this.type = type;
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
        this.customer = customer;
        this.schedule = schedule;
        this.available = available;
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


    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Set<Availability> getAvailable() {
        return available;
    }

    public void setAvailable(Set<Availability> available) {
        this.available = available;
    }
}
