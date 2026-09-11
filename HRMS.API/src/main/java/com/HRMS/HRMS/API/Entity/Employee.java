package com.HRMS.HRMS.API.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @NotNull(message = "First name is required")
    private String firstname;
    @NotNull(message = "Second name is required")
    private String lastname;
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Phone number is required")
    private  String phoneno;
    @NotNull(message = "Salary is required")
    private double salary;
    @NotNull(message = "Designation is required")
    private  String designation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Joining date is required")
    private Date joiningDate;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToMany(mappedBy = "employee")
    private List<Leave> leave =  new ArrayList<>();


    public Employee(Integer id, String firstname, String lastname, String phoneno, double salary, String designation, Date joiningDate, Department department, List<Leave> leave) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneno = phoneno;
        this.salary = salary;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.department = department;
        this.leave = leave;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Leave> getLeave() {
        return leave;
    }

    public void setLeave(List<Leave> leave) {
        this.leave = leave;
    }


}
