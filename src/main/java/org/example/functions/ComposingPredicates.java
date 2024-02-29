package org.example.functions;

import java.util.Objects;
import java.util.function.Predicate;

public class ComposingPredicates {

    public static void main(String[] args) {
        String hello = "hello";
        Predicate<String> isValidString = str -> !Objects.isNull(str);
        System.out.println("Validating a null String returned :" + isValidString.test(null));
        System.out.println("Validating a non-null String returned :" + isValidString.test(hello));

    }
}
