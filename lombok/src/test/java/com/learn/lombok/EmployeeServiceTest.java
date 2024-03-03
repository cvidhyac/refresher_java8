package com.learn.lombok;

import com.learn.lombok.model.EmployeeType;
import com.learn.lombok.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void getEmployees() {
        var employees = employeeService.getAllEmployees();
        assertNotNull(employees);
        assertEquals(10, employees.size());

    }

    @Test
    void resetsToCurrentDate() {
        int employeeId = employeeService.resetARandomEmployee();
        assertNotEquals(0, employeeId);
    }

    @Test
    void updateEmployeeToFullTime() {
        EmployeeType employeeType = employeeService.convertEmployeeToFullTime();
        assertEquals(EmployeeType.FTE, employeeType);
    }
}
