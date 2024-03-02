package org.example.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Consumer;

@Slf4j
public class Optionals {

    static Consumer<String> printMe = val -> log.info("Value of val is :" + val);

    public static void main(String[] args) throws Exception {

        Optional<String> firstOne = Optional.of("Hello");
        printMe.accept(firstOne.get());
        Optional<String> secondOne = Optional.empty();
        var secondStudent = secondOne.map(str -> {
                    log.info("I did not execute");
                    return str;
                })
                .orElseThrow(Exception::new);
        printMe.accept(secondStudent);
    }
}
