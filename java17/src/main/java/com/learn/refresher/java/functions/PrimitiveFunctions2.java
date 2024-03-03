package com.learn.refresher.java.functions;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.LongFunction;

@Slf4j
public class PrimitiveFunctions2 {

    static IntFunction<String> acceptsAPrimitiveIntReturnsAString = intVal -> "A";
    static DoubleFunction<String> acceptsAPrimitiveDoubleReturnsAString = doubleVal -> "B";
    static LongFunction<String> acceptsPrimitiveLongReturnsAString = longVal -> "C";

    static BiPredicate<String, String> accepts2StringsReturnsABoolean = (a, b) -> a.isEmpty() && null == b;

    static BiConsumer<String, String> accepts2StringsAndReturnsVoid = (a, b) -> log.info("value of param1 is ".concat(a)
            .concat(" value of param2 is").concat(b));

    static BiFunction<String, String, Integer> accepts2ArgsReturnsAInt = (a, b) -> a == null && b == null ? 0 : 1;

    static IntToDoubleFunction transformIntToDoubleFunction = intVal -> intVal;

    static DoubleToIntFunction transformDoubleToIntFunction = doubleVal -> (int) doubleVal;


    public static void main(String[] args) {

        log.info("Send a 5 to get A back ".concat(acceptsAPrimitiveIntReturnsAString.apply(5)));
        log.info("Send a 4.0, get a string back ".concat(acceptsAPrimitiveDoubleReturnsAString.apply(4.0)));
        log.info("Send a 3L, get a string ".concat(acceptsPrimitiveLongReturnsAString.apply(3L)));
        log.info("Send 2 strings, return boolean".concat(String.valueOf(accepts2StringsReturnsABoolean.test("A", "B"))));
        accepts2StringsAndReturnsVoid.accept("A", "B");
        log.info("Send 2 args, return int ".concat(String.valueOf(accepts2ArgsReturnsAInt.apply("A", "B"))));
        log.info("Transform Int to double ".concat(String.valueOf(transformIntToDoubleFunction.applyAsDouble(5))));
        log.info("Transform Double to Int".concat(String.valueOf(transformDoubleToIntFunction.applyAsInt(5.0))));
    }

}
