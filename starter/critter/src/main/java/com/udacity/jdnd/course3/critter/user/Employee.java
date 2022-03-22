package com.udacity.jdnd.course3.critter.user;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    @Column(name="name")
    private String name;

    @Column(name="skills")
    private Set<EmployeeSkill>skills = new HashSet<>();

    @Column(name="availability")
    private Set<DayOfWeek>availability= new HashSet<>();

    public Employee() {
    }

    public Employee(long employeeId, String name, Set<EmployeeSkill> skills, Set<DayOfWeek> availability) {
        this.employeeId = employeeId;
        this.name = name;
        this.skills = skills;
        this.availability = availability;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getAvailability() {
        return availability;
    }

    public void setAvailability(Set<DayOfWeek> availability) {
        this.availability = availability;
    }
}
