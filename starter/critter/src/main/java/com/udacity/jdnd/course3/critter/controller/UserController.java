package com.udacity.jdnd.course3.critter.controller;

import com.fasterxml.jackson.annotation.JsonView;

import com.udacity.jdnd.course3.critter.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.dto.Views;
import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import org.springframework.beans.*;
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



    @JsonView(Views.Public.class)
    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        //throw new UnsupportedOperationException();
        Long id = Optional.ofNullable(customerDTO.getId()).orElse(Long.valueOf(-1));
        Customer customer = new Customer(id,customerDTO.getName(),customerDTO.getPhoneNumber(),customerDTO.getNotes(),customerDTO.getPetIds());
        System.out.println("test : " + customerDTO.getId() + "name : " + customerDTO.getName());
        try{
            this.customerService.saveCustomer(customer);

            System.out.println("count the entities : " + this.customerService.countCustomers());


        }catch (UnsupportedOperationException ex){
            System.out.println(ex.getLocalizedMessage());}
        return this.convertCustomerToCustomerDTO(customer);
    }


    @JsonView(Views.class)
    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        //throw new UnsupportedOperationException();
        List<CustomerDTO> result = new ArrayList<>();
        ArrayList<Customer> customersToConvert;
        try{
            customersToConvert = this.customerService.findAllCustomers();
            customersToConvert.forEach(customer -> System.out.println("all the customer before conversion : " + customer.getName() + " BE4 ID : " + customer.getCustomerId()));

            result = collectionConvertCustomerToCustomerDTO(customersToConvert);
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
        throw new UnsupportedOperationException();
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }

    /* HELPER METHODS */


    private CustomerDTO convertCustomerToCustomerDTO(Customer customer){
        CustomerDTO customerDTO= new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    private Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }

    private List<CustomerDTO>collectionConvertCustomerToCustomerDTO(ArrayList<Customer>customers){
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

}
