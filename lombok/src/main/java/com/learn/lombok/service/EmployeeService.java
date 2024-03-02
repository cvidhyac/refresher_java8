package com.learn.lombok.service;

import com.learn.lombok.model.Employee;
import com.learn.lombok.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }
}
