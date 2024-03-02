package org.example.generics;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Lower Bounded Wildcards
 * 1. Used for expressing contravariance
 * "Contravariance" preserves the ordering of types from "more general to more specific", opposite of covariance.
 * 3. Java collections are contravariant when they use a super with a wildcard.
 * <p>
 * Remember PECS: Producers extend, Consumers super
 */
@Slf4j
public class LowerBoundedWildcards {

    public static void main(String[] args) {

        /*
         * A lower bounded wildcard is defined with a "super MyClass"
         * It means the value that modifies the assignment should be MyClass or above
         */
        List<? super String> values = new ArrayList<>();
        values.add("apple");
        printString(values);

        //By default when no variance is specified this is called "invariant"
        List<String> newValues = Stream.of("A", "B", "C").toList();
        printString(newValues);

        List<Object> listOfObjects = Arrays.asList("AA", "BB", "CC");
        printString(listOfObjects);
    }

    public static void printString(List<? super String> values) {
        Consumer<String> printStrings = str -> log.info("Value is " + str);
        List<? super String> result = values.stream().peek(val -> printStrings.accept((String) val)).toList();
        log.info("Results : {}", result);
    }
}
