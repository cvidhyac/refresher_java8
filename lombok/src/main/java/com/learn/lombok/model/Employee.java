package com.learn.lombok.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Builder
public class Employee {

    private int id;

    private String firstName;

    private String lastName;

    private Address address;

    private LocalDate joiningDate;
}
