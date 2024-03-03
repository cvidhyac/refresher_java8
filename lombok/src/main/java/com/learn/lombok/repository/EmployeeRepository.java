package com.learn.lombok.repository;

import com.learn.lombok.model.Employee;
import com.learn.lombok.service.EmployeeUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Supplier;

@Repository
public class EmployeeRepository {

    Supplier<List<Employee>> employeeSupplier = () -> EmployeeUtil.randomEmployees(10);

    public List<Employee> findAll() {
        return employeeSupplier.get();
    }
}
