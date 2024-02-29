package org.example.streams;

import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ParallelStreams {

    public static void main(String[] args) {
        Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades();

        // Observe fork join pool, and parallelism - one thread per core
        Function<List<Trade>, List<Trade>> isClosedTrade = trades -> trades.parallelStream()
                .filter(trade -> !trade.isOpenTrade())
                .peek(t -> System.out.printf("TraceId=%s Filter thread name=%s\n", t.instrument(), Thread.currentThread().getName()))
                .toList();
        System.out.println(isClosedTrade.apply(tradeSupplier.get()));
    }
}
