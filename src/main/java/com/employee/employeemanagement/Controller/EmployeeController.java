package com.employee.employeemanagement.Controller;


import com.employee.employeemanagement.Model.Employee;
import com.employee.employeemanagement.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //build create employee REST API
    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
      return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //build get all employees REST API
    @GetMapping("/getall")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();

    }
    //build get employee by ID REST API
    //http:localhost:8080/api/employees/"id"
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

}
