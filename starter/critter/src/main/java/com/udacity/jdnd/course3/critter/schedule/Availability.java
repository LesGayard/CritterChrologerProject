package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;

import javax.persistence.*;
import java.time.DayOfWeek;

@Entity
@Table(name="availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AvailabilityId;

    @Column(name="day")
    private DayOfWeek dayOfWeek;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_pet_id")
    private Pet pet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_employee_id")
    private Employee employeeAvailable;



    public Availability() {
    }

    public Availability(Long availabilityId, DayOfWeek dayOfWeek) {
        AvailabilityId = availabilityId;
        this.dayOfWeek = dayOfWeek;
    }

    public Long getAvailabilityId() {
        return AvailabilityId;
    }

    public void setAvailabilityId(Long availabilityId) {
        AvailabilityId = availabilityId;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Employee getEmployee() {
        return employeeAvailable;
    }

    public void setEmployee(Employee employeeAvailable) {
        this.employeeAvailable = employeeAvailable;
    }
}
