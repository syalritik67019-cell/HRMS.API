package com.HRMS.HRMS.API.Controller;

import com.HRMS.HRMS.API.Dto.DepartmentResponse;
import com.HRMS.HRMS.API.Entity.Department;
import com.HRMS.HRMS.API.Entity.Employee;
import com.HRMS.HRMS.API.Service.Departmentservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    Departmentservice  dservice;

    @PostMapping
    public ResponseEntity<DepartmentResponse> createdepartment(@Valid @RequestBody Department department){
        DepartmentResponse depart = dservice.createdepartment(department);
        return new ResponseEntity<>(depart,HttpStatus.CREATED);

    }
 @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updatedepartment(@PathVariable Integer id , @Valid @RequestBody Department department){
        DepartmentResponse depart = dservice.updatedepartment(id ,department);
            return  new ResponseEntity<>(depart, HttpStatus.OK);
 }
  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletedepartment(@PathVariable Integer id){
        dservice.deletedepartment(id);
        return ResponseEntity.noContent().build();
  }
  @GetMapping()
    public ResponseEntity<List<DepartmentResponse>> getallDepart(){
      List<DepartmentResponse> depart = dservice.getallDepart();
      return  new ResponseEntity<>(depart, HttpStatus.OK);
  }
  @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDeaprtById(@PathVariable Integer id){
        DepartmentResponse depart = dservice.getDepartById(id);
        return ResponseEntity.ok(depart);
  }
  @GetMapping("/{id}/employees")
    public ResponseEntity<List<Employee>> getEmployeeByDepart(@PathVariable Integer id){
        List<Employee> employees = dservice.getEmployeeByDepart(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
  }
}
