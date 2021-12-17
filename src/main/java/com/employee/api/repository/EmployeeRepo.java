package com.employee.api.repository;

import com.employee.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    // JpaRepository has some predefined db functionalities

    // <Employee, Long> - Table/Entity name and Primary key datatype (private Long id)

    Optional<Employee> findEmployeeById(Long id); // Spring automatically detects find as select from Employee By Id
}
