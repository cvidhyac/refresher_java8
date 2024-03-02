package com.learn.lombok.model;

import java.util.List;

public record Employee(int id, String firstName, String lastName, List<Address> addresses) {
}
