package org.example.streams;

import lombok.extern.slf4j.Slf4j;
import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class ParallelStreams {

    public static void main(String[] args) {
        Supplier<List<Trade>> tradeSupplier = TradeUtil::createTrades;

        // Observe fork join pool, and parallelism - one thread per core
        Function<List<Trade>, List<Trade>> isClosedTrade = trades -> trades.parallelStream()
                .filter(trade -> !trade.isOpenTrade())
                .peek(t -> log.info("TraceId={} Filter thread name={}", t.instrument(), Thread.currentThread().getName()))
                .toList();
        log.info("IsClosedTrade: {}", isClosedTrade.apply(tradeSupplier.get()));
    }
}
