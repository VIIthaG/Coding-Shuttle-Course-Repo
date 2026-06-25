package com.V2thaG.Spec.module2.dto;

/// DTO stands for Data Transfer Object and they are used when you would like to transfer the data from the client to the controllers and then the servers

import java.time.LocalDate;

/// You dont have any specific annotation for a DTO but you can define attributes within the class

public class EmployeeDTO {

    //attributes
    private Long id;
    private String name;
    private  String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    //basic constructor
    public EmployeeDTO(){

    }

    //All argument Constructor
    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    /// Here we have defined getters and setters for all of the attributes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
