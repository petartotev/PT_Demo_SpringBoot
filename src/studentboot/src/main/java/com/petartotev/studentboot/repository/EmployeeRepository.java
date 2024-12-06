package com.petartotev.studentboot.repository;

import com.petartotev.studentboot.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
    // Custom query methods can be added if necessary
}