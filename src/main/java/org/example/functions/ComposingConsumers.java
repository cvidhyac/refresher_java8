package org.example.functions;

import java.util.function.Consumer;

public class ComposingConsumers {

    public static void main(String[] args) {

        Consumer<String> testPersistence = str -> persist(str);
        Consumer<String> printString = str -> System.out.println("Completed saving: " + str);
        Consumer<String> saveAndPrint = testPersistence.andThen(printString);
        saveAndPrint.accept("hello");

    }

    public static void persist(String s) {
        System.out.println("Saving the string " + s + " to database");
    }
}
