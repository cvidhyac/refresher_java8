package org.example.collectors;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

@Slf4j
public class CustomCollectors {

    public static void main(String[] args) {
        collectInfoIntoCustomCollector();
    }

    private static void collectInfoIntoCustomCollector() {

        Supplier<List<Employee>> employeeSupplier = EmployeeUtil::createEmployees;
        Supplier<StringBuilder> stringSupplier = StringBuilder::new;

        BiConsumer<StringBuilder, Employee> addAComma = (sb, employee) -> sb.append(employee.name()).append(",");
        BiConsumer<StringBuilder, StringBuilder> thenJoinTogether = StringBuilder::append;

        StringBuilder namesAsCsv = employeeSupplier.get().stream().collect(stringSupplier, addAComma, thenJoinTogether);
        log.info("Names as CSV: {}", namesAsCsv);
        printStrings();
    }

    private static void printStrings(String... values) {
        log.info("Values: ".concat(Arrays.toString(values)));
    }
}
