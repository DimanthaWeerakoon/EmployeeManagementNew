package com.employee.employeemanagement.Service.Serviceimpl;

import com.employee.employeemanagement.Exception.ResourceNotFoundException;
import com.employee.employeemanagement.Model.Employee;
import com.employee.employeemanagement.Repositiory.EmployeeRepository;
import com.employee.employeemanagement.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent()){
//            return employee.get();
//        }else {
//            throw new ResourceNotFoundException("Employee", "ID", id);
//        }
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "ID", id));
    }


}
