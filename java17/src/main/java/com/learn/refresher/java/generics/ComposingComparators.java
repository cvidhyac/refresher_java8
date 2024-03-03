package com.learn.refresher.java.generics;

import com.learn.refresher.java.collectors.EmployeeUtil;
import lombok.extern.slf4j.Slf4j;
import com.learn.refresher.java.collectors.Employee;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

@Slf4j
public class ComposingComparators {

    public static void main(String[] args) {

        Supplier<List<Employee>> testEmployees = EmployeeUtil::createEmployees;
        Consumer<Optional<Employee>> printEmployee = e -> log.info("Employee - name: "
                .concat(e.map(Employee::name).orElseThrow(() -> new IllegalArgumentException("Name not present")))
                .concat(" city: ")
                .concat(e.map(Employee::city).orElseThrow(() -> new IllegalArgumentException("City not present")))
                .concat(" rating: ")
                .concat(String.valueOf(e.map(Employee::rating).orElseThrow(() -> new IllegalArgumentException("Rating not present")))));
        Supplier<Stream<Employee>> employeeStream = () -> testEmployees.get().stream();
        log.info("-------Demo Comparator Max attribute --------");
        demoComparatorsToFindMaximum(employeeStream, printEmployee);
        log.info("------- Demo Chaining Comparators --------");
        demoChainAndSortComparators(employeeStream, printEmployee);
    }

    private static void demoChainAndSortComparators(Supplier<Stream<Employee>> employeeStream,
                                                    Consumer<Optional<Employee>> printEmployee) {

        Predicate<Employee> isExecutive = Employee::executive;
        Optional<List<Employee>> employeesByRating = Optional.of(employeeStream.get()
                .filter(isExecutive)
                .sorted(comparing(Employee::city, naturalOrder())
                        .thenComparing(Employee::rating, reverseOrder()))
                .toList());
        employeesByRating.ifPresentOrElse(employees -> employees
                        .forEach(emp -> printEmployee.accept(Optional.of(emp))),
                () -> new IllegalStateException("Employee should not be null"));
    }

    private static void demoComparatorsToFindMaximum(Supplier<Stream<Employee>> employeeStream,
                                                     Consumer<Optional<Employee>> printEmployee) {
        Optional<Employee> maxEmployeeByCity = employeeStream.get().max(comparing(Employee::city));
        Optional<Employee> maxEmployeeById = employeeStream.get().max(comparingInt(Employee::id));
        printEmployee.accept(maxEmployeeById);
        printEmployee.accept(maxEmployeeByCity);
    }
}
