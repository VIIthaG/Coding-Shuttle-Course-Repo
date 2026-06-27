package com.V2thaG.Spec.module2.controllers;

import com.V2thaG.Spec.module2.dto.EmployeeDTO;
import com.V2thaG.Spec.module2.entities.EmployeeEntity;
import com.V2thaG.Spec.module2.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){     //here, the @PathVariable annotation takes the value from {employeeID} in the URL and put it into the employeeID parameter below in the function params.
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeId);   ///And now here the presentation layer doesn't directly try to reach the persistence layer, and instead it tries to go for the service layer and the service layer thus contacts the Repository ( Persistance layer )

        return employeeDTO
                .map(EmployeeDTO1 ->  ResponseEntity.ok(EmployeeDTO1))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping()
    //so basically here, if we enter the query-params after the '?' symbol in the url which denotes the query params which are optional, whatever is defined below is returned to us
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String value){

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployees(@RequestBody EmployeeDTO inputEmployee){
            EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>( savedEmployee, HttpStatus.CREATED);

    }

    @PutMapping(path ="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById( @RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){

        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById( @PathVariable Long employeeId){
            boolean gotDeleted =  employeeService.deleteEmployeeById(employeeId);
            if(!gotDeleted){
                return ResponseEntity.ok(true);
            }else{
                return ResponseEntity.notFound().build();
            }
    }

    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> patchEmployeeById( @RequestBody Map<String , Object > updates,@PathVariable Long employeeId ){
        EmployeeDTO employeeDTO =  employeeService.patchEmployeeById( employeeId, updates);
            if(employeeDTO ==null){
                return ResponseEntity.notFound().build();
            }else{return ResponseEntity.ok(employeeDTO);
            }
    }
}
