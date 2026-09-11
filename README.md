# HRMS API - Employee Management System

A RESTful Human Resource Management System (HRMS) API built using Java and Spring Boot. 
This project provides APIs to manage employees, departments, and employee leaves.

## 🚀 Features

- Employee Management
  - Create employee
  - Get all employees
  - Get employee by ID
  - Update employee
  - Delete employee
  - Search employees by first name
  - Search employees by designation

- Department Management
  - Create department
  - Get all departments
  - Get department by ID
  - Update department
  - Delete department
  - Get employees by department

- Leave Management
  - Create leave request
  - Get leave requests
  - Update leave status
  - Delete leave request

- Input validation
- Exception handling
- RESTful APIs
- MySQL database integration
- Spring Data JPA
- Hibernate ORM

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Jakarta Validation
- Postman

## 📁 Project Structure

```text
src/main/java/com/HRMS/HRMS/API
│
├── Controller
│   ├── DepartmentController.java
│   ├── EmployeeController.java
│   └── LeaveController.java
│
├── Dto
│   ├── DepartmentResponse.java
│   ├── EmployeeRequest.java
│   ├── EmployeeResponse.java
│   └── LeaveRequest.java
│
├── Entity
│   ├── Department.java
│   ├── Employee.java
│   ├── Leave.java
│   ├── LeaveStatus.java
│   └── LeaveType.java
│
├── Exceptions
│   ├── Globalexceptionhandller.java
│   └── ResourceNotFound.java
│
├── Repository
│   ├── DepartmentRepository.java
│   ├── EmployeeRepository.java
│   └── LeaveRepository.java
│
├── Service
│   ├── Departmentservice.java
│   ├── Employeeservice.java
│   └── Leaveservice.java
│
└── Application.java
