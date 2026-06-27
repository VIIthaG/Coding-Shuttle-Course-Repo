package com.V2thaG.Spec.module2.controllers;

import com.V2thaG.Spec.module2.dto.EmployeeDTO;
import com.V2thaG.Spec.module2.entities.EmployeeEntity;
import com.V2thaG.Spec.module2.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees") /// this line basically is used to denote the parent url directory of all of what is below, so for '/employeeId' it instead becomes: '/employees/employeeId'

public class EmployeeController {

    /// Component Scanning is a feature in springboot that scans all of the annotations of all the files present within the package that the springboot program is being worked on.
    /// As a result of this, all of the mappings present within out controller are given to the dispatcher servlet which gives a request to the server which takes care of the request inside the controller


    private final EmployeeService employeeService ;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }



    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){     //here, the @PathVariable annotation takes the value from {employeeID} in the URL and put it into the employeeID parameter below in the function params.
        return employeeService.getEmployeeById(employeeId);                     ///And now here the  presentation layer does'nt directly try to reach the persistance layer and  instead it tries to go for the service layer and the service layer thus contacts the Repository ( Persistance layer )
    }

    @GetMapping()
    //so basically here, if we enter the query-params after the '?' symbol in the url which denotes the query params which are optional, whatever is defined below is returned to us
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String value){

        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployees(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);

    }

    @PutMapping
    public String updateNewEmployees(){
        return "Hello from PUT";
    }
}
