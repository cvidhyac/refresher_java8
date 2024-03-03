package com.learn.refresher.lombok.model;

import lombok.NonNull;
import lombok.With;

import java.time.LocalDate;

public record Employee(int id,
                       @NonNull String firstName,
                       @NonNull String lastName,
                       @With @NonNull Address address,
                       @NonNull LocalDate joiningDate,
                       @With EmployeeType status) {
    public static Employee createWithDefaults(int id, String firstName, String lastName, Address address, LocalDate joiningDate) {
        return new Employee(id, firstName, lastName, address, joiningDate, EmployeeType.TEMP);
    }
}