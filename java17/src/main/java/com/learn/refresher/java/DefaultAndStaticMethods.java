package com.learn.refresher.java;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultAndStaticMethods {

    public static void main(String[] args) {

        EmployeeImpl employeeImpl = new EmployeeImpl();
        employeeImpl.find(1234);

        //static method is accessible
        log.info(Employee.getDefaultCountry());
    }

}

@Slf4j
class EmployeeImpl implements Employee {

    @Override
    public Employee find(int id) {
        //default method is accessible automatically.
        boolean executiveEmployee = isExecutive(id);
        log.info("ISExecutiveEmployee: {}", executiveEmployee);
        return null;
    }
}

@FunctionalInterface
interface Employee {

    Employee find(int id);

    default boolean isExecutive(int id) {
        return true;
    }

    static String getDefaultCountry() {
        return "Canada";
    }
}