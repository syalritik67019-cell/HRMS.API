package com.HRMS.HRMS.API.Service;

import com.HRMS.HRMS.API.Dto.LeaveRequest;
import com.HRMS.HRMS.API.Entity.Employee;
import com.HRMS.HRMS.API.Entity.Leave;
import com.HRMS.HRMS.API.Entity.LeaveStatus;
import com.HRMS.HRMS.API.Exceptions.ResourceNotFound;
import com.HRMS.HRMS.API.Repository.DepartmentRepository;
import com.HRMS.HRMS.API.Repository.EmployeeRepository;
import com.HRMS.HRMS.API.Repository.LeaveRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Component
public class Leaveservice {
    @Autowired
    EmployeeRepository erepo;

    @Autowired
    LeaveRepository lrepo;

    public Leave createLeave(@Valid LeaveRequest request) {
        Employee employee = erepo.findById(request.getEmployeeId())
                .orElseThrow(() ->
                new ResourceNotFound("Employee not found with id :: " + request.getEmployeeId()));

    Leave leave = new Leave();

    leave.setLeavetype(request.getLeavetype());
    leave.setStartDate(request.getStartDate());
    leave.setEndDate(request.getEndDate());
    leave.setReason(request.getReason());
    leave.setStatus(LeaveStatus.PENDING);
    leave.setEmployee(employee);

    return lrepo.save(leave);


    }

    public Leave approveLeave(Integer id) {
        Leave leave = getLeaveById(id);
        leave.setStatus(LeaveStatus.APPROVED);
        return lrepo.save(leave);

    }

 public Leave rejectLeave(Integer id){
        Leave leave = getLeaveById(id);
        leave.setStatus(LeaveStatus.REJECTED);
        return lrepo.save(leave);
 }

    public Leave getLeaveById(Integer id) {
  return lrepo.findById(id).orElseThrow(()->
          new ResourceNotFound("Leave not found with id :: " + id));

    }

    public List<Leave> getallLeaves() {
        return  lrepo.findAll();

    }

    public void deleteLeave(Integer id) {
        if(!lrepo.existsById(id)){
            throw new ResourceNotFound("employee not found with id :: " + id);
        }
        else {
            lrepo.deleteById(id);
        }
    }

    public List<Leave> getLeavesByEmp(Integer id) {
        if(!erepo.existsById(id)){
            throw new ResourceNotFound("Employee not found with id :: " +id);
        }else{
            return lrepo.findByEmployeeId(id);
        }
    }
}
