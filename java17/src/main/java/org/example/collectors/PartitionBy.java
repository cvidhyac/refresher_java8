package org.example.collectors;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

@Slf4j
public class PartitionBy {

    static Supplier<List<Employee>> employeeSupplier = EmployeeUtil::createEmployees;
    static Consumer<Map<Boolean, List<Employee>>> printSinglePartition = map -> log.info("MapValue : {}", map);
    static Consumer<Map<Boolean, Map<String, List<Employee>>>> printMultiPartition = map -> log.info("MapValue : {}", map);

    public static void main(String[] args) {
        printSinglePartition.accept(partitionByExecutives());
        printMultiPartition.accept(partitionByExecutivesInCity());
    }

    //A partitionBy HAS to contain a predicate key. A groupingBy does not have to contain a predicate
    private static Map<Boolean, List<Employee>> partitionByExecutives() {
        return employeeSupplier.get().stream().collect(partitioningBy(Employee::executive));
    }

    private static Map<Boolean, Map<String, List<Employee>>> partitionByExecutivesInCity() {
        return employeeSupplier.get().stream().collect(partitioningBy(Employee::executive, groupingBy(Employee::city)));
    }
}
