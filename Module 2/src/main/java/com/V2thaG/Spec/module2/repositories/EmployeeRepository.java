package com.V2thaG.Spec.module2.repositories;

import com.V2thaG.Spec.module2.dto.EmployeeDTO;
import com.V2thaG.Spec.module2.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/// we make this as an interface instead of a class since SpringJPA takes
/// care of the queries like getting the data or updating the data from the table and back in the day we needed to make
/// methods to take care of each and every one of these actions which we dont now, Hence this is the reason as to why we make this an interface and not an actual class, since we dont have to make any methods


@Repository // Adding this annotation makes the interface a repository bean
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> //enter within the '< >' the entity that you wish for JPA to handle and also the datatype of the Primary key which would be Long in this case
{

}
