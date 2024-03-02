package org.example.generics;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ToDoubleFunction;

/**
 * Use Upper Bounded wildcards on collections to :
 * 1. Define the assignment
 * 2. Read from the assignment
 * 3. You cannot add to the assignment (READ only)
 * <p>
 * Generic java collections are a "covariant" when it uses an "extends with a wildcard"
 * <p>
 * An upper bounded wildcard collection is unmodifiable, except when used as a stream
 * The term covariant preserves the ordering of types from "more specific to more general"
 */
@Slf4j
public class UpperBoundedWildcards {

    static BiConsumer<String, String> printWildcard = (message, str) -> log.info(message.concat(str));

    public static void main(String[] args) {


        /* Example of an unbounded wildcard
         * An unbounded wildcard can be read with casting however cannot be modified
         */
        List<?> stuff = List.of("apple", "banana");
        // stuff.add("abc"); //Note - adding to list does not compile
        printWildcard.accept("Printing first element in list: ", (String) stuff.get(0)); //reading works


        List<? extends Number> numbers = List.of(3, 3.14, BigDecimal.valueOf(4.5));
        //        numbers.add(2); note that this line doesn't compile
        ToDoubleFunction<List<? extends Number>> sumFunction = UpperBoundedWildcards::sumList;
        Double value = sumFunction.applyAsDouble(numbers);
        printWildcard.accept("Sum of all elements in list: ", String.valueOf(value));
    }

    private static double sumList(List<? extends Number> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }
}
