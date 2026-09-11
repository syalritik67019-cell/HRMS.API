package com.HRMS.HRMS.API.Repository;

import com.HRMS.HRMS.API.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Component
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);
}