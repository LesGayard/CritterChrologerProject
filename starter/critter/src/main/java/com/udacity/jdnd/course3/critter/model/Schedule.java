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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "schedule_pet",
            joinColumns = {@JoinColumn(name = "schedule_id")},
            inverseJoinColumns = {@JoinColumn(name = "pet_id")})
    private Pet pet;

    @ManyToMany(targetEntity = Employee.class,mappedBy = "schedule")
    @JoinTable(name = "schedule_employee",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees = new ArrayList<>();


    @Column(name="appointment")
    private Date appointment;


    public Schedule() {
    }

    public Schedule(Long scheduleId, Pet pet, List<Employee> employees, Date appointment) {
        this.scheduleId = scheduleId;
        this.pet = pet;
        this.employees = employees;
        this.appointment = appointment;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }
}
