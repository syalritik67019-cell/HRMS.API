package com.HRMS.HRMS.API.Controller;
import com.HRMS.HRMS.API.Dto.EmployeeRequest;
import com.HRMS.HRMS.API.Dto.EmployeeResponse;
import com.HRMS.HRMS.API.Entity.Employee;
import com.HRMS.HRMS.API.Service.Employeeservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    Employeeservice eserivice;

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@Valid @RequestBody EmployeeRequest request){
  EmployeeResponse save = eserivice.create(request);
  if(save != null){
    return  new ResponseEntity<>(save,HttpStatus.CREATED);
  }
  else {
     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateemployee(@PathVariable Integer id ,@Valid @RequestBody EmployeeRequest request ){
        EmployeeResponse response = eserivice.updateemployee(id,request);
        return  ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        eserivice.delete(id);
      return   ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getallemlpoyes(){
        List<EmployeeResponse> getall = eserivice.getallemployes();
        return  new ResponseEntity<>(getall, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> findbyid(@PathVariable Integer id){
        EmployeeResponse findid = eserivice.findbyid(id);
        return  new ResponseEntity<>(findid, HttpStatus.OK);
    }
    @GetMapping("/Search")
    public ResponseEntity<List<EmployeeResponse>> searchByFirstName(@RequestParam String fname){
        List<EmployeeResponse> sfirstname = eserivice.searchByFirstName(fname);
        return ResponseEntity.ok(sfirstname);
    }
    @GetMapping("/Search/designation")
    public  ResponseEntity<List<EmployeeResponse>> searchByDesignation(@RequestParam String desi){
       List<EmployeeResponse> sbydesignation = eserivice.searchByDesignation(desi);
        return ResponseEntity.ok(sbydesignation);
    }
}
