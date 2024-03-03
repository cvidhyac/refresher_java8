package com.learn.refresher.java.streams;

import lombok.extern.slf4j.Slf4j;
import com.learn.refresher.java.collectors.Employee;
import com.learn.refresher.java.collectors.EmployeeUtil;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
public class FlatMapOperation {

    static Supplier<List<Employee>> employeeSupplier = EmployeeUtil::createEmployees;
    static Consumer<List<String>> printFoods = list -> log.info(String.valueOf(list));
    public static void main(String[] args){

        List<Employee> employees = employeeSupplier.get();
        List<String> foods = employees.stream()
                .flatMap(m -> m.food().stream())
                .distinct()
                .toList();
        printFoods.accept(foods);
    }
}
