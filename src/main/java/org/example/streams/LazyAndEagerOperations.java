package org.example.streams;

import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LazyAndEagerOperations {

    static Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades();

    public static void testLazyStream() {
        tradeSupplier.get().stream().filter(trade -> {
            System.out.println("Lazy Stream: Starting to filter trades");
            return trade.isOpenTrade();
        }).limit(2);
    }

    public static void testEagerStreams() {
        tradeSupplier.get().stream().filter(trade -> {
            System.out.println("Eager Stream: Starting to filter trades");
            return trade.isOpenTrade();
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //observe system.out does not executed because terminal operator is not set
        testLazyStream();

        //observe system.out. gets printed
        testEagerStreams();
    }
}
