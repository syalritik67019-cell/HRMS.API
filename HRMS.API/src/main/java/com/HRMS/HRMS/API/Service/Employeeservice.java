package com.HRMS.HRMS.API.Service;
import com.HRMS.HRMS.API.Dto.EmployeeRequest;
import com.HRMS.HRMS.API.Dto.EmployeeResponse;
import com.HRMS.HRMS.API.Entity.Department;
import com.HRMS.HRMS.API.Entity.Employee;
import com.HRMS.HRMS.API.Exceptions.ResourceNotFound;
import com.HRMS.HRMS.API.Repository.DepartmentRepository;
import com.HRMS.HRMS.API.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class Employeeservice {

    @Autowired
    EmployeeRepository erepo;
    @Autowired
    DepartmentRepository drepo;

    public EmployeeResponse create(EmployeeRequest request) {
        Department  department = drepo.findById(request.getDepartmentId())
                .orElseThrow(()->
                new ResourceNotFound("Department not found with id: "
                                           + request.getDepartmentId()));

        Employee employee =  new Employee();

        employee.setFirstname(request.getFirstName());
        employee.setLastname(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhoneno(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDesignation(request.getDesignation());
        employee.setJoiningDate(request.getJoiningDate());
        employee.setDepartment(department);

        Employee savedemployee = erepo.save(employee);
        return convertToResponse(savedemployee);
    }
    public EmployeeResponse updateemployee(Integer id, EmployeeRequest request){
   Employee employeeexist = erepo.findById(id).
           orElseThrow(()->
                   new ResourceNotFound("Employee with this id " + id + "not found"));

   Department departmentexist =drepo.findById(request.getDepartmentId()).
           orElseThrow(()->
                   new ResourceNotFound("Department not found with id: "
                           + request.getDepartmentId()));


        employeeexist.setFirstname(request.getFirstName());
        employeeexist.setLastname(request.getLastName());
        employeeexist.setEmail(request.getEmail());
        employeeexist.setPhoneno(request.getPhone());
        employeeexist.setSalary(request.getSalary());
        employeeexist.setDesignation(request.getDesignation());
        employeeexist.setJoiningDate(request.getJoiningDate());
        employeeexist.setDepartment(departmentexist);

        Employee updateemployee = erepo.save(employeeexist);
        return convertToResponse(updateemployee);
    }

    public void delete(Integer id) {
        if(!erepo.existsById(id)){
            throw new ResourceNotFound("Employee with id " + id + "not found");
        }else{
            erepo.deleteById(id);
        }

    }

    public List<EmployeeResponse> getallemployes() {
        List<Employee> employees = erepo.findAll();
        return employees.stream()
                .map(this::convertToResponse)
                .toList();
    }

    public EmployeeResponse findbyid(Integer id) {
       Employee employee = erepo.findById(id)
                       .orElseThrow(()->
                        new RuntimeException("Employee with this id " + id + "not found"));
       return convertToResponse(employee);
    }

    public List<EmployeeResponse> searchByFirstName(String name){
        List<Employee> employees = erepo.findByFirstnameContainingIgnoreCase(name);
        return employees.stream()
                .map(this::convertToResponse)
                .toList();
    }

    public List<EmployeeResponse> searchByDesignation(String desi){
        List<Employee> employees = erepo.findByDesignationContainingIgnoreCase(desi);
        return employees.stream()
                .map(this::convertToResponse)
                .toList();
    }

    private EmployeeResponse convertToResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();

     response.setId(employee.getId());
        response.setFirstName(employee.getFirstname());
        response.setLastName(employee.getLastname());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhoneno());
        response.setsalary(employee.getSalary());
        response.setDesignation(employee.getDesignation());
        response.setJoiningDate(employee.getJoiningDate());

        if (employee.getDepartment() != null) {

            response.setDepartmentId(
                    employee.getDepartment().getId()
            );

            response.setDepartmentName(
                    employee.getDepartment().getName()
            );
        }
      return  response;
    }
}
