package com.learn.refresher.java.functions;

import com.learn.refresher.java.lambda.Trade;
import com.learn.refresher.java.lambda.TradeUtil;
import lombok.extern.slf4j.Slf4j;

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
