package org.example.streams;

import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Supplier;

public class StreamIterations {

    static Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades();

    public static void main(String[] args) {
        tradeSupplier.get().stream()
                .filter(trade -> trade.isOpenTrade())
                .limit(2)
                .toList();
    }
}
