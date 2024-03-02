package org.example.functions;

import lombok.extern.slf4j.Slf4j;
import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
public class ComposingSuppliers {
    static Supplier<List<Trade>> tradeSupplier = TradeUtil::createTrades;
    static Consumer<Trade> printTrades = trade -> log.info("Closed Trade Instrument name : " + trade.instrument());

    public static void main(String[] args) {
        List<Trade> openTrades = tradeSupplier.get().stream().filter(trade -> !trade.isOpenTrade()).toList();
        openTrades.forEach(trade -> printTrades.accept(trade));
    }


}
