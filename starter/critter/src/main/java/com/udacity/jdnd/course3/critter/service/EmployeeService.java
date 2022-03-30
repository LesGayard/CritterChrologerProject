package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    /* SAVE AN EMPLOYEE */
    public Employee saveEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    /* COUNT THE EMPLOYEES */
    public long countEmployees(){
        return this.employeeRepository.count();
    }

    /* GET AN EMPLOYEE BY ITS ID  CUSTOM METHOD */
    public Employee findEmployeeById(long id) {
        long foundId = Optional.ofNullable(id).orElse((long) -1);
        return this.employeeRepository.findById(foundId);

    }

}
