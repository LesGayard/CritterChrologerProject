package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;

    @OneToMany(mappedBy = "schedule")
    private Employee employeeAvailable;

    @OneToOne(mappedBy = "schedule")
    private Pet petAvailable;

    @Column(name="appointment")
    private Date appointment;

    @Column(name="activities")
    private Set<EmployeeSkill>activities = new HashSet<>();

    public Schedule() {
    }

    public Schedule(Long scheduleId, Employee employeeAvailable, Pet petAvailable, Date appointment, Set<EmployeeSkill> activities) {
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

    public Employee getEmployeeAvailable() {
        return employeeAvailable;
    }

    public void setEmployeeAvailable(Employee employeeAvailable) {
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

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
