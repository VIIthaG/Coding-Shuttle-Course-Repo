package com.V2thaG.Spec.module2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/// In this class, you define the structure of the table in the DB and here, you would also mention fields with sensitive data such as Passwords, keys etc...
/// thus you abstract those kinds of fields from the class with the DTO in it, which has exposabale fields that aren't sensitive (i.e DTO class fields can be sent with the response).

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//This tells hibernate that this is the java class that you need to convert to a new table inside the database
@Table(name ="employees")       //this annotation is just used to define the table's name, if you are not using it then the tables name will just be the class' name
public class EmployeeEntity {

    //the attributes mentioned in this class shall be turned into the fields of the table that exists in our database
    /// Generally here in the class with @Entity, you would define the logic for the table structure and also define any constraints

    //every entity requires a Primary Key thus we use @Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // this is used to tell hibernate that this Key of ours is an autoincrement
    private Long id;
    private String name;
    private  String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;
}
