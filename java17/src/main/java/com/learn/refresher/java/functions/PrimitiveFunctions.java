package com.learn.refresher.java.functions;

import lombok.extern.slf4j.Slf4j;

import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.Predicate;

@Slf4j
public class PrimitiveFunctions {

    //predicate to check if a number is divisible by 2
    static Predicate<Integer> isDivisibleByTwo = x -> x % 2 == 0;

    static IntPredicate isDivisibleByThree = x -> x % 3 == 0;
    static IntConsumer printPrimeResponse = num -> log.info("The number is divisible By 3, received " + num);
    static IntConsumer printEvenResponse = num -> log.info("The number is divisible by 2, received " + num);


    //List Of Primitive Predicates
    IntPredicate intPredicate = null;
    LongPredicate longPredicate = null;
    DoublePredicate doublePredicate = null;

    //List of Primitive Consumers
    IntConsumer intConsumer = null; // accept int return void
    LongConsumer longConsumer = null; // accept long return void
    DoubleConsumer doubleConsumer = null; // accept double return void

    //List of Primitive Suppliers
    IntSupplier intSupplier = null; //accepts no args returns an int
    LongSupplier longSupplier = null; //accepts no args returns a long
    DoubleSupplier doubleSupplier = null; //accepts no args returns a double

    public static void main(String[] args) {

        int numberToCheck = 434;
        if (isDivisibleByThree.test(numberToCheck)) {
            printPrimeResponse.accept(numberToCheck);
        } else {
            printEvenResponse.accept(numberToCheck);
        }
    }
}
