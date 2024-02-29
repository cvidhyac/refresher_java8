package org.example.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class CustomCollectors {

    public static void main(String[] args) {
        collectInfoIntoCustomCollector();
    }
    private static void collectInfoIntoCustomCollector() {

        Supplier<List<Employee>> employeeSupplier = () -> EmployeeUtil.createEmployees();
        Supplier<StringBuilder> stringSupplier = () -> new StringBuilder();

        BiConsumer<StringBuilder, Employee> addAComma = (sb, employee) -> sb.append(employee.name()).append(",");
        BiConsumer<StringBuilder, StringBuilder> thenJoinTogether = (sb1, sb2) -> sb1.append(sb2);

        StringBuilder namesAsCsv = employeeSupplier.get().stream().collect(stringSupplier, addAComma, thenJoinTogether);
        System.out.println(namesAsCsv);
        printStrings();
    }

    private static void printStrings(String... values) {
        System.out.println("Values: ".concat(Arrays.toString(values)));
    }
}
