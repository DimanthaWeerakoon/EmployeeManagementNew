package com.employee.employeemanagement.Repositiory;

import com.employee.employeemanagement.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
