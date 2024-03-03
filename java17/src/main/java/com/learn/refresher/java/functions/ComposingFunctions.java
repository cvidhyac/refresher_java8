package com.learn.refresher.java.functions;

import com.learn.refresher.java.lambda.Trade;
import com.learn.refresher.java.lambda.TradeUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class ComposingFunctions {

    static Supplier<List<Trade>> tradeSupplier = TradeUtil::createTrades;
    static Function<String, Trade> findInstrumentByName = name -> tradeSupplier.get().stream()
            .filter(trade -> name.equals(trade.instrument()))
            .findFirst().orElse(null);

    static Function<Integer, List<Trade>> findTradesExceedingAmount = amount -> tradeSupplier.get().stream()
            .filter(trade -> trade.amount() > amount).toList();

    static Function<List<Trade>, Double> findSumOfGivenTrades = trades -> trades.stream()
            .mapToDouble(Trade::amount).sum();

    static Function<String, List<Trade>> findTradesStartwithPrefix = prefix -> tradeSupplier.get().stream()
            .filter(trade -> trade.instrument().startsWith(prefix)).toList();

    private static Double findSumOfTradesExceedingGivenAmount(Integer amount) {
        Function<Integer, Double> chainedFunction = findTradesExceedingAmount.andThen(findSumOfGivenTrades);
        return chainedFunction.apply(amount);
    }

    private static Double findSumOfTradeInstrumentsByPrefix() {
        Function<String, Double> chainedFunction = findSumOfGivenTrades.compose(findTradesStartwithPrefix);
        return chainedFunction.apply("A");
    }

    public static void main(String[] args) {

        //A simple function that accepts name and returns a Trade object
        Trade t = findInstrumentByName.apply("IBM");
        log.info(t.toString());

        //An example of chained function using andThen chain
        log.info("Trades Exceeding Given Amount".concat(findSumOfTradesExceedingGivenAmount(300).toString()));

        //A chained function using 'compose' chain computes the reverse way than andThen
        log.info("Trade Instruments By prefix".concat(findSumOfTradeInstrumentsByPrefix().toString()));
    }


}
