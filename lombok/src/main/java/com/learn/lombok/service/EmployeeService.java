package com.learn.lombok.service;

import com.learn.lombok.model.Employee;
import com.learn.lombok.model.EmployeeType;
import com.learn.lombok.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        log.info("Reset a random employee and return id");
        val employee = employeeRepository.resetImmutableRandom();
        return employee.id();
    }

    public EmployeeType convertEmployeeToFullTime() {
        log.info("Update fields in employee object after it is initially created");
        val employee = employeeRepository.resetMutableRandom();
        return employee.status();
    }
}
