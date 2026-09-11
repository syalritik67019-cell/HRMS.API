package com.HRMS.HRMS.API.Service;

import com.HRMS.HRMS.API.Dto.DepartmentResponse;
import com.HRMS.HRMS.API.Entity.Department;
import com.HRMS.HRMS.API.Entity.Employee;
import com.HRMS.HRMS.API.Exceptions.ResourceNotFound;
import com.HRMS.HRMS.API.Repository.DepartmentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Departmentservice {

    @Autowired
    DepartmentRepository drepo;

    public DepartmentResponse createdepartment(@Valid Department department) {
     if(drepo.existsByNameIgnoreCase(department.getName())){
         throw new IllegalArgumentException(
                 "Department with this name already exists: " + department.getName()
         );
     }
       Department savesdepart = drepo.save(department);
     return convertToResponse(savesdepart);
    }

    public DepartmentResponse updatedepartment(Integer id ,Department departmentdetails) {
        Department departrepo = drepo.findById(id)
                .orElseThrow(() ->
                new ResourceNotFound("Department with this id " + id + "not exists"));


             departrepo.setName(departmentdetails.getName());
             departrepo.setDescription(departmentdetails.getDescription());

          Department updatedepart = drepo.save(departrepo);
          return convertToResponse(updatedepart);
    }


    public void deletedepartment(Integer id) {
        if(!drepo.existsById(id)){
            throw new ResourceNotFound("Department with this id " + id + "not exists");
        }
        else {
            drepo.deleteById(id);
        }
    }


    public List<DepartmentResponse> getallDepart() {
     List<Department> department = drepo.findAll();
     return department.stream()
             .map(this::convertToResponse)
             .toList();
    }

    public DepartmentResponse getDepartById(Integer id) {
        Department depart = drepo.findById(id).orElseThrow(()->
                 new ResourceNotFound("Department with this id " + id + "not exist"));
        return convertToResponse(depart);
    }


    public List<Employee> getEmployeeByDepart(Integer id) {
        Department department = drepo.findById(id)
                .orElseThrow(()->
                        new ResourceNotFound("Department with this id " + id + " not exits"));
        return department.getEmployee();
    }
    private DepartmentResponse convertToResponse(Department depart) {
        DepartmentResponse departmentRes = new DepartmentResponse();
        departmentRes.setId(depart.getId());
        departmentRes.setName(depart.getName());
        departmentRes.setDescription(depart.getDescription());
        if (depart.getEmployee() != null) {
            departmentRes.setEmployeeCount(depart.getEmployee().size());
        } else {
            departmentRes.setEmployeeCount(0);
        }
        return departmentRes;

    }
}
