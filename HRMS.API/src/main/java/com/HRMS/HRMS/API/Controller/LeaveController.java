package com.HRMS.HRMS.API.Controller;

import com.HRMS.HRMS.API.Dto.LeaveRequest;
import com.HRMS.HRMS.API.Entity.Leave;
import com.HRMS.HRMS.API.Service.Leaveservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {
    @Autowired
    Leaveservice lsercice;

    @PostMapping
    public ResponseEntity<Leave> createLeave(@Valid @RequestBody LeaveRequest lRequest){
        Leave leaverequest =  lsercice.createLeave(lRequest);
        return new ResponseEntity<>(leaverequest , HttpStatus.CREATED);
    }
    @PutMapping("/{id}/approve")
    public ResponseEntity<Leave> approveLeave(@PathVariable Integer id){
        Leave update = lsercice.approveLeave(id);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }
    @PutMapping("/{id}/reject")
    public ResponseEntity<Leave> rejectLeave(@PathVariable Integer id){
        Leave update = lsercice.rejectLeave(id);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Integer id){
        lsercice.deleteLeave(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Leave>> getallLeaves(){
        List<Leave> leaves = lsercice.getallLeaves();
        return ResponseEntity.ok(leaves);
    }
 @GetMapping("/{id}")
    public ResponseEntity<Leave> getLeaveById(@PathVariable Integer id){
        Leave get = lsercice.getLeaveById(id);
        return ResponseEntity.ok(get);
 }
 @GetMapping("/employee/{employeeid}")
    public ResponseEntity<List<Leave>> getLeavesByEmp(@PathVariable Integer id){
        List<Leave> leaves = lsercice.getLeavesByEmp(id);
        return ResponseEntity.ok(leaves);
 }

}
