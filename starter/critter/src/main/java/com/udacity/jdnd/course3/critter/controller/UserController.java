package com.udacity.jdnd.course3.critter.controller;

import com.fasterxml.jackson.annotation.JsonView;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.dto.Views;
import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.service.CustomerService;

import com.udacity.jdnd.course3.critter.service.EmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.Set;



/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Converter converter;

    @Autowired
    private EmployeeService employeeService;

    @JsonView(Views.Public.class)
    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){

        Customer customer = new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getPhoneNumber(),customerDTO.getNotes(),customerDTO.getPetIds());
        System.out.println("test : " + customerDTO.getId() + "name : " + customerDTO.getName());
        try{
            this.customerService.saveCustomer(customer);

            System.out.println("count the entities : " + this.customerService.countCustomers());


        }catch (UnsupportedOperationException ex){
            System.out.println(ex.getLocalizedMessage());}
        return this.converter.convertCustomerToCustomerDTO(customer);
    }


    @JsonView(Views.class)
    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        //throw new UnsupportedOperationException();
        List<CustomerDTO> result = new ArrayList<>();
        ArrayList<Customer> customersToConvert = new ArrayList<>();
        try{
            customersToConvert = this.customerService.findAllCustomers();
            customersToConvert.forEach(customer -> System.out.println("all the customer before conversion : " + customer.getName() + " BE4 ID : " + customer.getCustomerId()));

            result = this.converter.collectionConvertCustomerToCustomerDTO(customersToConvert);
            result.forEach(result01 -> System.out.println("After conversion Id : " + result01.getId()));
           System.out.println("final size test : " + result.size());

       }catch(UnsupportedOperationException ex){
            ex.getLocalizedMessage();
        }
        return result;

    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        throw new UnsupportedOperationException();
    }



    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        //throw new UnsupportedOperationException();
        EmployeeDTO employeeToSave = new EmployeeDTO();
        Employee employeeToConvert = new Employee(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getSkills(),employeeDTO.getDaysAvailable());
        System.out.println("Test Employee name : " + employeeDTO.getName() + " ID : " + employeeDTO.getId());
        try{
            this.employeeService.saveEmployee(employeeToConvert);
            System.out.println("count the entities saved : " + this.employeeService.countEmployees());
        }catch (UnsupportedOperationException exception){
            exception.getLocalizedMessage();
        }
        return this.converter.convertEmployeeToEmployeeDTO(employeeToConvert);
    }



    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        System.out.println("EmployeeDTO ID : " + employeeDTO.getId());

        Employee employee = new Employee(employeeId);


        System.out.println("Employee ID  :  " + employee.getEmployeeId());
        System.out.println("Test source Employee :" + employee.getName());
        try{
            if(employee == null){
                throw new NotFoundException("Source is null");
            }else{
                employeeDTO = this.converter.convertEmployeeToEmployeeDTO(employee);
            }
            //System.out.println("Employee ID before conversion : " + employee.getEmployeeId());
        }catch (UnsupportedOperationException exception){
            exception.getLocalizedMessage();
        } catch (NotFoundException e) {
            e.getLocalizedMessage();
            System.out.println("The source is not saved ! Cannot find it It is null");
        }
        return employeeDTO;
    }



    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }



    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }

}
