package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;

    @OneToMany(mappedBy = "schedule")
    private List<Employee> employeeAvailable = new ArrayList<>();

    @OneToOne(mappedBy = "schedule")
    private Pet petAvailable;

    @Column(name="appointment")
    private Date appointment;

    @ManyToMany(mappedBy = "schedule")
    private Set<Employee>activities = new HashSet<>();

    public Schedule() {
    }

    public Schedule(Long scheduleId, List<Employee> employeeAvailable, Pet petAvailable, Date appointment, Set<Employee> activities) {
        this.scheduleId = scheduleId;
        this.employeeAvailable = employeeAvailable;
        this.petAvailable = petAvailable;
        this.appointment = appointment;
        this.activities = activities;
    }


    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<Employee> getEmployeeAvailable() {
        return employeeAvailable;
    }

    public void setEmployeeAvailable(List<Employee> employeeAvailable) {
        this.employeeAvailable = employeeAvailable;
    }

    public Pet getPetAvailable() {
        return petAvailable;
    }

    public void setPetAvailable(Pet petAvailable) {
        this.petAvailable = petAvailable;
    }

    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    public Set<Employee> getActivities() {
        return activities;
    }

    public void setActivities(Set<Employee> activities) {
        this.activities = activities;
    }
}
