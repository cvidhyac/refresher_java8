package org.example.generics;

import org.example.collectors.Employee;
import org.example.collectors.EmployeeUtil;

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

public class ComposingComparators {

    public static void main(String[] args) {

        Supplier<List<Employee>> testEmployees = EmployeeUtil::createEmployees;
        Consumer<Optional<Employee>> printEmployee = e -> System.out.println("Employee - name: "
                .concat(e.get().name())
                .concat(" city: ")
                .concat(e.get().city())
                .concat(" rating: ")
                .concat(String.valueOf(e.get().rating())));
        Supplier<Stream<Employee>> employeeStream = () -> testEmployees.get().stream();
        System.out.println("-------Demo Comparator Max attribute --------");
        demoComparatorsToFindMaximum(employeeStream, printEmployee);
        System.out.println("------- Demo Chaining Comparators --------");
        demoChainAndSortComparators(employeeStream, printEmployee);
    }

    private static void demoChainAndSortComparators(Supplier<Stream<Employee>> employeeStream,
                                                    Consumer<Optional<Employee>> printEmployee) {

        Predicate<Employee> isExecutive = e -> e.executive();
        Optional<List<Employee>> employeesByRating = Optional.of(employeeStream.get()
                .filter(isExecutive)
                .sorted(comparing(Employee::city, naturalOrder())
                        .thenComparing(Employee::rating, reverseOrder()))
                .toList());
        employeesByRating.ifPresentOrElse(employees -> employees.stream()
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
