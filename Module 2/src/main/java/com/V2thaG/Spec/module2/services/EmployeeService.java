package com.V2thaG.Spec.module2.services;

import com.V2thaG.Spec.module2.dto.EmployeeDTO;
import com.V2thaG.Spec.module2.entities.EmployeeEntity;
import com.V2thaG.Spec.module2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository; // You are going to inject the repository here so that the service layer (which has been created as a result of creating this class )
                                                        // can communicate with the presentation layer and thus the service layer can communicate with the persistance layer
    private final ModelMapper modelMapper;


    public EmployeeService(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;

    }


    public Optional<EmployeeDTO> getEmployeeById(Long employeeId) {                                                          /// We would not like for our controller to directly use the Entity that we have created and instead what we would like is for it to instead interact with the DTO class

        //        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);                        /// We are using Maven ModelMapper here and it basically creates an object of a class that has the fields and attributes of another class. In this case, the ModelMapper takes the fields of the Entity class and creates an Object of the DTO class using those same fields
        //        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));       // This simply returns the employeeDTO object but with the fields of the Entity. Now since we dont want to keep repeating ourself here, we shall  define a config file to make this into a bean
       /// Now let us combine the above two statements to make it easier on ourselves

       return employeeRepository.findById(employeeId).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class) );
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }


    /// Just making this method over here since we will have to use this bit of code twice as you can see below in the delete and patch functions. DRY methodology (Do not Repeat Yourself)
    public boolean checkEmployeeStatus(Long employeeId) {

        return employeeRepository.existsById(employeeId);

    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists = checkEmployeeStatus(employeeId);
        if (!exists) {
            return false;
        } else {
            employeeRepository.deleteById(employeeId);
            return true;
        }
    }

    public EmployeeDTO patchEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exists = checkEmployeeStatus(employeeId);
        if (!exists) {
            return null;
        }

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach ( (field,value)->  {

            /// Reflection allows Java to inspect and modify the fields of an Object,that's the whole point of using them here
            /// Furthermore by updating the object here in memory, we can update the object in the database when employeeRepository.save() is called below.

            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });


        return modelMapper.map( employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}