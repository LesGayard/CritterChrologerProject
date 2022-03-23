package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.EmployeeSkill;
import com.udacity.jdnd.course3.critter.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    /* Find out which employees with the right skills are available on a given date */
    public List<Employee> findEmployeeBySkillAndAvailable(EmployeeSkill skill, DayOfWeek day, Date givenDate);
}
