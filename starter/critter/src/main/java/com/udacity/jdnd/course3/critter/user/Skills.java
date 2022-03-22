package com.udacity.jdnd.course3.critter.user;

import javax.persistence.*;

@Entity
@Table(name="skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skills_id")
    private Long skillsId;

    @Column(name="name")
    private EmployeeSkill skill;

    @ManyToOne
    private Employee employeeSkill;


}
