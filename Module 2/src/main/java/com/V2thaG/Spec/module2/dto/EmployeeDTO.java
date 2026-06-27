package com.V2thaG.Spec.module2.dto;

/// DTO stands for Data Transfer Object and they are used when you would like to transfer the data from the client to the controllers and then the servers

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

/// You dont have any specific annotation for a DTO but you can define attributes within the class
/// Note that in this class with the DTO in it, you would define the validation for each attribute as in you would check if say the name or age is valid or not

//we have now gotten rid of all of the getter, setter, empty and non empty constructors in favour of using

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


    /**
     *
     */
    //attributes


    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    @JsonProperty("active")
    //@JsonProperty() tells Jackson what JSON field name to use. i.e it uses whatever you have mentioned in the brackets
    private Boolean isActive;
}

    //basic constructor
//    public EmployeeDTO(){
//
//    }

    //All argument Constructor
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }

/// Here we have defined getters and setters for all of the attributes
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public Boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(Boolean active) {
//        isActive = active;
//    }
//}