package org.example.functions;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.LongFunction;

public class PrimitiveFunctions2 {

    static IntFunction<String> acceptsAPrimitiveIntReturnsAString = intVal -> "A";
    static DoubleFunction<String> acceptsAPrimitiveDoubleReturnsAString = doubleVal -> "B";
    static LongFunction<String> acceptsPrimitiveLongReturnsAString = longVal -> "C";

    static BiPredicate<String, String> accepts2StringsReturnsABoolean = (a, b) -> a.isEmpty() && null == b;

    static BiConsumer<String, String> accepts2StringsAndReturnsVoid = (a, b) -> System.out.println("value of param1 is ".concat(a)
            .concat(" value of param2 is").concat(b));

    static BiFunction<String, String, Integer> accepts2ArgsReturnsAInt = (a, b) -> a == null && b == null ? 0 : 1;

    static IntToDoubleFunction transformIntToDoubleFunction = intVal -> intVal;

    static DoubleToIntFunction transformDoubleToIntFunction = doubleVal -> Double.valueOf(doubleVal).intValue();


    public static void main(String[] args) {

        System.out.println("Send a 5 to get A back ".concat(acceptsAPrimitiveIntReturnsAString.apply(5)));
        System.out.println("Send a 4.0, get a string back ".concat(acceptsAPrimitiveDoubleReturnsAString.apply(4.0)));
        System.out.println("Send a 3L, get a string ".concat(acceptsPrimitiveLongReturnsAString.apply(3L)));
        System.out.println("Send 2 strings, return boolean".concat(String.valueOf(accepts2StringsReturnsABoolean.test("A", "B"))));
        accepts2StringsAndReturnsVoid.accept("A", "B");
        System.out.println("Send 2 args, return int ".concat(String.valueOf(accepts2ArgsReturnsAInt.apply("A", "B"))));
        System.out.println("Transform Int to double ".concat(String.valueOf(transformIntToDoubleFunction.applyAsDouble(5))));
        System.out.println("Transform Double to Int".concat(String.valueOf(transformDoubleToIntFunction.applyAsInt(5.0))));
    }

}
