package com.learn.lombok.repository;

import com.learn.lombok.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    public List<Employee> findAll() {
        return List.of();
    }
}
