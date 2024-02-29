package org.example.streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class RangeAndStats {

    static Supplier<IntStream> withoutEndSupplier = () -> IntStream.range(10, 20);
    static Supplier<IntStream> withEndSupplier = () -> IntStream.rangeClosed(10, 20);


    public static void main(String[] args) {
        int maxValue = withoutEndSupplier.get().max().orElseThrow(() -> new IllegalStateException("Unexpected Max value"));
        int minValue = withoutEndSupplier.get().min().orElseThrow(() -> new IllegalStateException("Unexpected Min value"));
        double averageValue = withoutEndSupplier.get().average().orElseThrow(() -> new IllegalStateException("Unexpected Average value"));

        IntSummaryStatistics summaryStatistics = withEndSupplier.get().summaryStatistics();

        //Option 1 : Find from intstream individually
        System.out.println("Max:".concat(String.valueOf(maxValue)));
        System.out.println("Min:".concat(String.valueOf(minValue)));
        System.out.println("Average:".concat(String.valueOf(averageValue)));

        //Option 2: Find from summary statistics util
        System.out.println("Summary stats: " + summaryStatistics);
    }
}
