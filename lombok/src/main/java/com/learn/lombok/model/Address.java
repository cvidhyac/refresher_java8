package com.learn.lombok.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.With;

@Builder
@EqualsAndHashCode
public class Address {

    @Builder.Default
    @With
    private AddressType addressType = AddressType.HOME;

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


