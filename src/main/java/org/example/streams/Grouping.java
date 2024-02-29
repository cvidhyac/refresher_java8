package org.example.streams;

import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Supplier;

public class Grouping {

    public static void main(String[] args) {

        Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades();
    }
}
