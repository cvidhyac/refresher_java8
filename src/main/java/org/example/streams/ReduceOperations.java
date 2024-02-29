package org.example.streams;

import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Supplier;

public class ReduceOperations {

    static Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades();
    public static List<String> findDistinctInstruments() {
        return tradeSupplier.get().stream()
                .filter(trade -> trade.isOpenTrade())
                .map(trade -> trade.instrument())
                .distinct()
                .reduce(((str1, str2) -> str1 + "," + str2)).stream().toList();
    }

    public static void main(String[] args) {
        Supplier<List<String>> distinctInstruments = ReduceOperations::findDistinctInstruments;
        distinctInstruments.get().stream().forEach(System.out::println);
    }
}
