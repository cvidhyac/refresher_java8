package com.learn.lombok;

import com.learn.lombok.model.Employee;
import com.learn.lombok.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void getEmployees() {

        List<Employee> employees = employeeService.getAllEmployees();
        // Assertions
        assertNotNull(employees); // Check that the list is not null
        assertEquals(10, employees.size()); // Check that the list has 10 elements

    }
}
