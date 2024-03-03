package com.learn.refresher.java.functions;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class ComposingConsumers {

    public static void main(String[] args) {

        Consumer<String> testPersistence = ComposingConsumers::persist;
        Consumer<String> printString = str -> log.info("Completed saving: " + str);
        Consumer<String> saveAndPrint = testPersistence.andThen(printString);
        saveAndPrint.accept("hello");

    }

    public static void persist(String s) {
        log.info("Saving the string " + s + " to database");
    }
}
