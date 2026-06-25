package com.V2thaG.Spec.module2.controllers;

import com.V2thaG.Spec.module2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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


    @GetMapping("/employees/{employeeId}")
    //here, the @PathVariable annotation takes the value from {employeeID} in the URL and put it into the employeeID parameter below in the function params.

    public EmployeeDTO getEmployeeById( @PathVariable Long employeeId){
        return new EmployeeDTO(employeeId, "VG","vllthag@gmail.com", 27, LocalDate.of(2026,6,25), true);

        /// And here with the power of Jackson, our java object automatically gets converted into a json
    }

    @GetMapping()
    //so basically here, if we enter the queryparams after the '?' symbol in the url which denotes the query params which are optional, whatever is defined below is returned to us
    public String getEmployee(@RequestParam(required = false) Integer age,
                              @RequestParam(required = false) String value){

        return "Hi!  "+ value + " You are this old: " + age;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L); //100L is just 100 the number but L stands for Long as in the datatype
        return inputEmployee;
    }

    @PutMapping
    public String updateNewEmployee(){
        return "Hello from PUT";
    }
}
