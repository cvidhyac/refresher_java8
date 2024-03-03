package com.learn.lombok.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Builder
@EqualsAndHashCode
public class Address {

    private int unitNumber;

    @NonNull
    private String addressLine;

    @NonNull
    private String city;

    @NonNull
    private String country;

    @NonNull
    private String zipCode;
}
