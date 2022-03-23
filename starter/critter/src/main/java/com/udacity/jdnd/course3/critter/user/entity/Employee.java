package com.udacity.jdnd.course3.critter.user.entity;


import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
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

    @ElementCollection(targetClass = EmployeeSkill.class)
    @CollectionTable(name = "employee_skill", joinColumns = @JoinColumn(name = "employee_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "skills")
    private Set <EmployeeSkill> skills = new HashSet<>();

    @ElementCollection
    @CollectionTable(name="available_days", joinColumns = @JoinColumn(name="employee_id"))
    @Column(name="employee_available_days")
    private Set<DayOfWeek> days = new HashSet<>();


    public Employee() {}

    public Employee(long employeeId, String name, Set<EmployeeSkill> skills, Set<DayOfWeek> days) {
        this.employeeId = employeeId;
        this.name = name;
        this.skills = skills;
        this.days = days;
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

    public Set<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(Set<DayOfWeek> days) {
        this.days = days;
    }
}
