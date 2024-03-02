package org.example.streams;

import lombok.extern.slf4j.Slf4j;
import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Slf4j
public class LazyAndEagerOperations {

    static Supplier<List<Trade>> tradeSupplier = TradeUtil::createTrades;

    public static void testLazyStream() {
        Stream<Trade> tradeStream = tradeSupplier.get().stream().filter(trade -> {
            log.info("Lazy Stream: Starting to filter trades");
            return trade.isOpenTrade();
        }).limit(2);
        log.info("Lazy Stream does not execute and returns a stream, {}", tradeStream);
    }

    public static void testEagerStreams() {
        List<Trade> openTrades = tradeSupplier.get().stream().filter(trade -> {
            log.info("Eager Stream: Starting to filter trades");
            return trade.isOpenTrade();
        }).toList();
        log.info("Number Of Open Trades: {}", openTrades);
    }

    public static void main(String[] args) {
        //observe system.out does not executed because terminal operator is not set
        testLazyStream();

        //observe system.out. gets printed
        testEagerStreams();
    }
}
