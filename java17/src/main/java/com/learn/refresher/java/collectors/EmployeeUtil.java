package com.learn.refresher.java.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {

    public static final String FINANCE = "Finance";
    public static final String VANCOUVER = "Vancouver";

    private EmployeeUtil() {}
    public static final String TORONTO = "Toronto";
    public static final String DEPARTMENT = "IT";
    public static final String NEW_YORK = "New York";
    public static final String OPERATIONS = "Operations";

    public static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();

        List<String> foodTypeOne = Arrays.asList("Pizza", "Ice-cream");
        List<String> foodTypeTwo = Arrays.asList("HotDog", "Burrito");
        List<String> foodTypeThree = Arrays.asList("Pizza", "Fries");

        employees.add(new Employee(1, "bob", DEPARTMENT, TORONTO, foodTypeOne, false, 50));
        employees.add(new Employee(2, "cob", DEPARTMENT, TORONTO, foodTypeOne, false, 60));
        employees.add(new Employee(3, "dob", DEPARTMENT, TORONTO, foodTypeOne, true, 70));
        employees.add(new Employee(4, "eob", DEPARTMENT, TORONTO, foodTypeOne, true, 80));
        employees.add(new Employee(5, "fob", DEPARTMENT, TORONTO, foodTypeOne, false, 50));
        employees.add(new Employee(6, "gob", DEPARTMENT, TORONTO, foodTypeOne, false, 60));
        employees.add(new Employee(7, "hob", DEPARTMENT, TORONTO, foodTypeOne, false, 70));

        //next set
        employees.add(new Employee(8, "iob", OPERATIONS, NEW_YORK, foodTypeTwo, false, 80));
        employees.add(new Employee(9, "job", OPERATIONS, NEW_YORK, foodTypeTwo, false, 50));
        employees.add(new Employee(10, "kob", OPERATIONS, NEW_YORK, foodTypeTwo, true, 60));
        employees.add(new Employee(11, "lob", OPERATIONS, NEW_YORK, foodTypeTwo, true, 70));
        employees.add(new Employee(12, "mob", OPERATIONS, NEW_YORK, foodTypeTwo, true, 80));
        employees.add(new Employee(13, "nob", OPERATIONS, NEW_YORK, foodTypeTwo, false, 85));
        employees.add(new Employee(14, "oob", OPERATIONS, NEW_YORK, foodTypeTwo, false, 90));

        //next set
        employees.add(new Employee(15, "pob", FINANCE, VANCOUVER, foodTypeThree, false, 55));
        employees.add(new Employee(16, "qob", FINANCE, VANCOUVER, foodTypeThree, false, 60));
        employees.add(new Employee(17, "rob", FINANCE, VANCOUVER, foodTypeThree, false, 66));
        employees.add(new Employee(18, "sob", FINANCE, VANCOUVER, foodTypeThree, false, 59));
        employees.add(new Employee(19, "tob", FINANCE, VANCOUVER, foodTypeThree, true, 91));
        employees.add(new Employee(20, "uob", FINANCE, VANCOUVER, foodTypeThree, true, 50));
        employees.add(new Employee(21, "vob", FINANCE, VANCOUVER, foodTypeThree, true, 70));

        return employees;
    }
}
