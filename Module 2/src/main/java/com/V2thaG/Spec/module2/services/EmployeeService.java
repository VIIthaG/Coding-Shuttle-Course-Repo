package com.V2thaG.Spec.module2.services;

import com.V2thaG.Spec.module2.dto.EmployeeDTO;
import com.V2thaG.Spec.module2.entities.EmployeeEntity;
import com.V2thaG.Spec.module2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository; // You are going to inject the repository here so that the service layer (which has been created as a result of creating this class )
                                                         // can communicate with the presentation layer and thus the service layer can communicate with the persistance layer
    private final ModelMapper modelMapper;



    public EmployeeService ( ModelMapper modelMapper, EmployeeRepository employeeRepository ) {
        this.modelMapper =  modelMapper;
        this.employeeRepository = employeeRepository;

    }



    public EmployeeDTO getEmployeeById(Long employeeId) {                                             /// We would not like for our controller to directly use the Entity that we have created and instead what we would like is for it to instead interact with the DTO class
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);   /// We are using Maven ModelMapper here and it basically creates an object of a class that has the fields and attributes of another class. In this case, the ModelMapper takes the fields of the Entity class and creates an Object of the DTO class using those same fields
         return modelMapper.map(employeeEntity, EmployeeDTO.class);  // This simply returns the employeeDTO object but with the fields of the Entity. Now since we dont want to keep repeating ourself here, we shall  define a config file to make this into a bean
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity =  modelMapper.map( inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }
}
