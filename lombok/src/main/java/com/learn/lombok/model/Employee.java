package com.learn.lombok.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
@Builder
public class Employee {

    private int id;

    private String firstName;

    private String lastName;

    private Address address;

    private LocalDate joiningDate;
}
