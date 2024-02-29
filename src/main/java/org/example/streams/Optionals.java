package org.example.streams;

import java.util.Optional;
import java.util.function.Consumer;

public class Optionals {

    static Consumer<String> printMe = (val) -> System.out.println("Value of val is :" + val);

    public static void main(String[] args) throws Exception {

        Optional<String> firstOne = Optional.of("Hello");
        printMe.accept(firstOne.get());
        String student = null;
        Optional<String> secondOne = Optional.ofNullable(student);
        var secondStudent = secondOne.map(str -> {
                    System.out.println("I did not execute");
                    return str;
                })
                .orElseThrow(Exception::new);
        printMe.accept(secondStudent);
    }
}
