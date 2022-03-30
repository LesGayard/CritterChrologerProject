package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/* CONVERTER CLASS THAT CONVERTS DTO TO ENTITIES FOR THE CONTROLLERS */
@Configuration
public class Converter {


    public Converter() {
    }

    /* HELPER METHODS  FOR THE CUSTOMER */

    public CustomerDTO convertCustomerToCustomerDTO(Customer customer){
        CustomerDTO customerDTO= new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }

    public List<CustomerDTO> collectionConvertCustomerToCustomerDTO(ArrayList<Customer> customers){
        List<CustomerDTO>customerDTOS = new ArrayList<>();

        customers.forEach(
                customer -> {
                    customerDTOS.add(convertCustomerToCustomerDTO(customer));
                }
        );
        //customerDTOS.forEach(customerDTO -> System.out.println("Helper method costumers : " + customerDTO.getName()));
        //System.out.println("Helper method customers size : " + customerDTOS.size());
        return customerDTOS;
    }

    /* HELPER METHODS FOR THE EMPLOYEEE */
    public EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee,employeeDTO);
        return employeeDTO;
    }

}
