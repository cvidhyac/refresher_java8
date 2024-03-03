package com.learn.refresher.lombok.service;

import com.learn.refresher.lombok.model.Address;
import com.learn.refresher.lombok.model.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class EmployeeUtil {

    private EmployeeUtil() {
    }

    private static final String[] FIRST_NAMES = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson"};

    private static final String[] COUNTRIES = {"USA", "Canada", "UK", "Australia", "Germany"};
    private static final String[] CITIES = {"New York", "Los Angeles", "Toronto", "London", "Sydney", "Berlin"};
    private static final String[] ZIP_CODES = {"10001", "M5H 2N2", "SW1A 1AA", "2000", "10115"};

    private static final Random random = new Random();
    private static final String[] ADDRESSES = {
            "Main St, Springfield",
            "Elm St, Anytown",
            "Oak St, Smalltown",
            "Pine St, Bigcity",
            "Maple St, Countryside"
    };

    public static List<Employee> randomEmployees(int maxNumber) {
        return IntStream.range(0, maxNumber)
                .mapToObj(obj -> randomEmployee())
                .toList();
    }

    private static String randomField(String[] fieldArray) {
        return fieldArray[random.nextInt(fieldArray.length)];
    }

    private static int randomId() {
        return random.nextInt();
    }


    public static Address randomAddress() {
        return Address.builder().unitNumber(randomId())
                .addressLine(randomField(ADDRESSES))
                .city(randomField(CITIES))
                .country(randomField(COUNTRIES))
                .zipCode(randomField(ZIP_CODES)).build();
    }

    public static LocalDate randomDate(int startYear, int endYear) {

        var minDay = (int) LocalDate.of(startYear, 1, 1).toEpochDay();
        var maxDay = (int) LocalDate.of(endYear, 12, 31).toEpochDay();
        var randomDay = minDay + (long) random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private static Employee randomEmployee() {
        return Employee.createWithDefaults(randomId(),
                randomField(FIRST_NAMES),
                randomField(LAST_NAMES),
                randomAddress(),
                randomDate(1980, 2024));
    }

}
