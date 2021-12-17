package com.employee.api.service;

import com.employee.api.exception.EmployeeNotFoundException;
import com.employee.api.model.Employee;
import com.employee.api.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee by id " +id +" is not found"));
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmpCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepo.delete(employee);
    }
}
