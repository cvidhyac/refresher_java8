package org.example.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.IntSummaryStatistics;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@Slf4j
public class RangeAndStats {

    static Supplier<IntStream> withoutEndSupplier = () -> IntStream.range(10, 20);
    static Supplier<IntStream> withEndSupplier = () -> IntStream.rangeClosed(10, 20);


    public static void main(String[] args) {
        int maxValue = withoutEndSupplier.get().max().orElseThrow(() -> new IllegalStateException("Unexpected Max value"));
        int minValue = withoutEndSupplier.get().min().orElseThrow(() -> new IllegalStateException("Unexpected Min value"));
        double averageValue = withoutEndSupplier.get().average().orElseThrow(() -> new IllegalStateException("Unexpected Average value"));

        IntSummaryStatistics summaryStatistics = withEndSupplier.get().summaryStatistics();

        //Option 1 : Find from intstream individually
        log.info("Max:".concat(String.valueOf(maxValue)));
        log.info("Min:".concat(String.valueOf(minValue)));
        log.info("Average:".concat(String.valueOf(averageValue)));

        //Option 2: Find from summary statistics util
        log.info("Summary stats: " + summaryStatistics);
    }
}
