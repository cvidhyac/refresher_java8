package com.learn.lombok.repository;

import com.learn.lombok.model.Employee;
import com.learn.lombok.service.EmployeeUtil;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

@Repository
public class EmployeeRepository {

    Supplier<List<Employee>> employeeSupplier = () -> EmployeeUtil.randomEmployees(10);

    public List<Employee> findAll() {
        return employeeSupplier.get();
    }

    public Employee resetRandom() {
        //use lombok val to assign final values of local inference types
        val employee = employeeSupplier.get().stream()
                .findAny();

        //does not modify the data in the supplier
        return employee.map(obj -> Employee.builder().id(obj.getId())
                .address(obj.getAddress())
                .firstName(obj.getFirstName())
                .lastName(obj.getLastName())
                .joiningDate(LocalDate.now()).build())
                .orElseThrow(() -> new IllegalArgumentException("Employee cannot be null"));
    }
}
