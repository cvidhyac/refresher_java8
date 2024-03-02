package org.example.streams;

import lombok.extern.slf4j.Slf4j;
import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class StreamIterations {

    static Supplier<List<Trade>> tradeSupplier = TradeUtil::createTrades;

    public static void main(String[] args) {
        List<Trade> anyTwoOpenTrades = tradeSupplier.get().stream()
                .filter(Trade::isOpenTrade)
                .limit(2)
                .toList();
        log.info("Print Any 2 Trades: {}", anyTwoOpenTrades);
    }
}
