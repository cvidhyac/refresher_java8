package com.learn.refresher.java.streams;

import com.learn.refresher.java.lambda.Trade;
import com.learn.refresher.java.lambda.TradeUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class ReduceOperations {

    static Supplier<List<Trade>> tradeSupplier = TradeUtil::createTrades;
    public static List<String> findDistinctInstruments() {
        return tradeSupplier.get().stream()
                .filter(Trade::isOpenTrade)
                .map(Trade::instrument)
                .distinct()
                .reduce(((str1, str2) -> str1 + "," + str2)).stream().toList();
    }

    public static void main(String[] args) {
        Supplier<List<String>> distinctInstruments = ReduceOperations::findDistinctInstruments;
        distinctInstruments.get().forEach(log::info);
    }
}
