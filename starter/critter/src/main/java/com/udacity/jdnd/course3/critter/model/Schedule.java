package com.udacity.jdnd.course3.critter.model;


import javax.persistence.*;
import java.util.*;


/* Schedules that indicate one or more employees will be meeting one or more pets to perform one or more activities on a specific day */
@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="schedule_id")
    private Long scheduleId;

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "schedule_pet",
            joinColumns = {@JoinColumn(name = "schedule_id")},
            inverseJoinColumns = {@JoinColumn(name = "pet_id")})
    private List<Pet>pets = new ArrayList<>();*/

    @ManyToMany(targetEntity = Employee.class)
    @JoinTable(name = "schedule_employee",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees = new ArrayList<>();


    @Column(name="appointment")
    private Date appointment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee_id")
    private Employee employee;*/




    public Schedule() {
    }


    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }


    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
