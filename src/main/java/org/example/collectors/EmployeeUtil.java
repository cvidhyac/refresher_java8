package org.example.collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {

    public static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();

        List<String> foodTypeOne = Arrays.asList("Pizza", "Ice-cream");
        List<String> foodTypeTwo = Arrays.asList("HotDog", "Burrito");
        List<String> foodTypeThree = Arrays.asList("Pizza", "Fries");

        employees.add(new Employee(1, "bob", "IT", "Toronto", foodTypeOne, false, 50));
        employees.add(new Employee(2, "cob", "IT", "Toronto", foodTypeOne, false, 60));
        employees.add(new Employee(3, "dob", "IT", "Toronto", foodTypeOne, true, 70));
        employees.add(new Employee(4, "eob", "IT", "Toronto", foodTypeOne, true, 80));
        employees.add(new Employee(5, "fob", "IT", "Toronto", foodTypeOne, false, 50));
        employees.add(new Employee(6, "gob", "IT", "Toronto", foodTypeOne, false, 60));
        employees.add(new Employee(7, "hob", "IT", "Toronto", foodTypeOne, false, 70));

        //next set
        employees.add(new Employee(8, "iob", "Operations", "New York", foodTypeTwo, false, 80));
        employees.add(new Employee(9, "job", "Operations", "New York", foodTypeTwo, false, 50));
        employees.add(new Employee(10, "kob", "Operations", "New York", foodTypeTwo, true, 60));
        employees.add(new Employee(11, "lob", "Operations", "New York", foodTypeTwo, true, 70));
        employees.add(new Employee(12, "mob", "Operations", "New York", foodTypeTwo, true, 80));
        employees.add(new Employee(13, "nob", "Operations", "New York", foodTypeTwo, false, 85));
        employees.add(new Employee(14, "oob", "Operations", "New York", foodTypeTwo, false, 90));

        //next set
        employees.add(new Employee(15, "pob", "Finance", "Vancouver", foodTypeThree, false, 55));
        employees.add(new Employee(16, "qob", "Finance", "Vancouver", foodTypeThree, false, 60));
        employees.add(new Employee(17, "rob", "Finance", "Vancouver", foodTypeThree, false, 66));
        employees.add(new Employee(18, "sob", "Finance", "Vancouver", foodTypeThree, false, 59));
        employees.add(new Employee(19, "tob", "Finance", "Vancouver", foodTypeThree, true, 91));
        employees.add(new Employee(20, "uob", "Finance", "Vancouver", foodTypeThree, true, 50));
        employees.add(new Employee(21, "vob", "Finance", "Vancouver", foodTypeThree, true, 70));

        return employees;
    }
}
