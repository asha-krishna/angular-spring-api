package com.employee.api.controller;

import com.employee.api.service.EmployeeService;
import com.employee.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.findAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
        Employee emp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee emp = employeeService.findEmployeeById(id); // retrieve existed employee from DB based on id
        emp.setName(employee.getName());
        emp.setPhone(employee.getPhone());
        emp.setJobTitle(employee.getJobTitle());
        emp.setEmail(employee.getEmail());
        emp.setImageUrl(employee.getImageUrl());
        Employee updatedEmployee = employeeService.updateEmployee(emp);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id); // retrieve existed employee from DB based on id
        employeeService.deleteEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
