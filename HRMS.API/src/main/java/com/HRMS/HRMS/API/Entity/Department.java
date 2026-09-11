package com.HRMS.HRMS.API.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

   @NotBlank(message = "Department name is required")
   private String name;
   private  String description;

@OneToMany(mappedBy = "department")
    private List<Employee> employee =  new ArrayList<>();

    public Department(Integer id, String name, String description, List<Employee> employee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.employee = employee != null ? employee : new ArrayList<>();
    }

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee != null ? employee : new ArrayList<>();
    }
}
