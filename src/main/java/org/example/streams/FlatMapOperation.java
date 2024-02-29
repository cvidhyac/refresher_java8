package org.example.streams;

import org.example.collectors.Employee;
import org.example.collectors.EmployeeUtil;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FlatMapOperation {

    static Supplier<List<Employee>> employeeSupplier = () -> EmployeeUtil.createEmployees();
    static Consumer<List<String>> printFoods = list -> System.out.println(list);
    public static void main(String[] args){

        List<Employee> employees = employeeSupplier.get();
        List<String> foods = employees.stream()
                .flatMap(m -> m.food().stream())
                .distinct()
                .toList();
        printFoods.accept(foods);
    }
}
