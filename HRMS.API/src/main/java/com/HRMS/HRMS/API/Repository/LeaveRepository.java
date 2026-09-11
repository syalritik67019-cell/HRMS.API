package com.HRMS.HRMS.API.Repository;

import com.HRMS.HRMS.API.Entity.Leave;
import com.HRMS.HRMS.API.Entity.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

    List<Leave> findByEmployeeId(Integer employeeId);

    List<Leave> findByStatus(LeaveStatus status);
}