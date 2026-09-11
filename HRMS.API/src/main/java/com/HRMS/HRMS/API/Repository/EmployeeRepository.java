package com.HRMS.HRMS.API.Repository;

import com.HRMS.HRMS.API.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmail(String email);
    List<Employee> findByFirstnameContainingIgnoreCase(String firstName);

    List<Employee> findByLastnameContainingIgnoreCase(String lastname);

    List<Employee> findByDesignationContainingIgnoreCase(String designation);
}