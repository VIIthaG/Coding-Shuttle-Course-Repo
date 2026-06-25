package com.V2thaG.Spec.module2.controllers;

import com.V2thaG.Spec.module2.dto.EmployeeDTO;
import com.V2thaG.Spec.module2.entities.EmployeeEntity;
import com.V2thaG.Spec.module2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees") /// this line basically is used to denote the parent url directory of all of what is below, so for '/employeeId' it instead becomes: '/employees/employeeId'

public class EmployeeController {

    /// Component Scanning is a feature in springboot that scans all of the annotations of all the files present within the package that the springboot program is being worked on.
    /// As a result of this, all of the mappings present within out controller are given to the dispatcher servlet which gives a request to the server which takes care of the request inside the controller

    //this one here is the mapping
//    @GetMapping(path= "/getSecretMessage") //
//    public String getMySuperSecretMessage(){
//
//        return "Secret Message: aoihgg@$)(%)";
//    }


    private final EmployeeRepository employeeRepository ;

    //Keep in mind that the controllers should ideally be connected to the service layer and then only connected to the entity layer, not like here where the entity and controllers are directly hooked up
    public EmployeeController(EmployeeRepository employeeRepository ) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById( @PathVariable Long employeeId){     //here, the @PathVariable annotation takes the value from {employeeID} in the URL and put it into the employeeID parameter below in the function params.
        return employeeRepository.findById(employeeId).orElse(null);       //we are using JPA's predefined method .findById() to return a method instead of a predefined object like what we did in lecture 2.2
                                                                               /// And here with the power of Jackson, our java object automatically gets converted into a json
    }

    @GetMapping()
    //so basically here, if we enter the query-params after the '?' symbol in the url which denotes the query params which are optional, whatever is defined below is returned to us
    public List<EmployeeEntity> getAllEmployee(@RequestParam(required = false) Integer age,
                                               @RequestParam(required = false) String value){

        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);

    }

    @PutMapping
    public String updateNewEmployee(){
        return "Hello from PUT";
    }
}
