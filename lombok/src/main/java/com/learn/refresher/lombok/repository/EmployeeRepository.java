package com.learn.refresher.lombok.repository;

import com.learn.refresher.lombok.model.AddressType;
import com.learn.refresher.lombok.model.Employee;
import com.learn.refresher.lombok.model.EmployeeType;
import com.learn.refresher.lombok.service.EmployeeUtil;
import lombok.Getter;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

@Repository
public class EmployeeRepository {

    //Note - note the use of getEmployeeSupplier() method to access the cached response
    @Getter(lazy = true)
    private final Supplier<List<Employee>> employeeSupplier = () -> EmployeeUtil.randomEmployees(10);

    public List<Employee> findAll() {
        return getEmployeeSupplier().get();
    }

    public Employee resetImmutableRandom() {
        //use lombok val to assign final values of local inference types
        val employee = getEmployeeSupplier().get().stream()
                .findAny();

        //The only way to modify an 'Immutable field' is to copy it over to a new object
        val newJoiningDate = LocalDate.now();
        return employee.map(obj -> new Employee(obj.id(), obj.firstName(), obj.lastName(), obj.address(),
                        newJoiningDate, EmployeeType.TEMP))
                .orElseThrow(() -> new IllegalArgumentException("Employee cannot be null"));
    }

    public Employee resetMutableRandom() {
        val employee = getEmployeeSupplier().get().stream().findAny();

        return employee.map(obj -> obj.withStatus(EmployeeType.FTE))
                .map(obj -> obj.withAddress(obj.address().withAddressType(AddressType.OFFICE)))
                .orElseThrow(() -> new IllegalArgumentException("Employee cannot be null"));
    }


}
