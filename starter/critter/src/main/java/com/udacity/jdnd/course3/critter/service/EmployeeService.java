package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;




    public EmployeeService() {
    }





    /* CREATE AN EMPLOYEE */
    public Employee createEmployee( Employee employee){
        return this.employeeRepository.save(employee);
    }
}
