package com.learn.lombok.service;

import com.learn.lombok.model.Employee;
import com.learn.lombok.repository.EmployeeRepository;
import lombok.val;
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

    public int resetARandomEmployee() {
        val employee = employeeRepository.resetRandom();
        return employee.getId();
    }
}
