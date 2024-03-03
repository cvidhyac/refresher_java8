package com.learn.refresher.java.functions;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Predicate;

@Slf4j
public class ComposingPredicates {

    public static void main(String[] args) {
        String hello = "hello";
        Predicate<String> isValidString = str -> !Objects.isNull(str);
        log.info("Validating a null String returned :" + isValidString.test(null));
        log.info("Validating a non-null String returned :" + isValidString.test(hello));

    }
}
