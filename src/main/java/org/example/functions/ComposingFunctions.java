package org.example.functions;

import org.example.lambda.Trade;
import org.example.lambda.TradeUtil;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ComposingFunctions {

    static Supplier<List<Trade>> tradeSupplier = () -> TradeUtil.createTrades();
    static Function<String, Trade> findInstrumentByName = name -> tradeSupplier.get().stream()
            .filter(trade -> name.equals(trade.instrument()))
            .findFirst().orElse(null);

    static Function<Integer, List<Trade>> findTradesExceedingAmount = amount -> tradeSupplier.get().stream()
            .filter(trade -> trade.amount() > amount).toList();

    static Function<List<Trade>, Double> findSumOfGivenTrades = trades -> trades.stream()
            .mapToDouble(trade -> trade.amount()).sum();

    static Function<String, List<Trade>> findTradesStartwithPrefix = prefix -> tradeSupplier.get().stream()
            .filter(trade -> trade.instrument().startsWith(prefix)).toList();

    private static Double findSumOfTradesExceedingGivenAmount(Integer amount) {
        Function<Integer, Double> chainedFunction = findTradesExceedingAmount.andThen(findSumOfGivenTrades);
        return chainedFunction.apply(amount);
    }

    private static Double findSumOfTradeInstrumentsByPrefix(String prefix) {
        Function<String, Double> chainedFunction = findSumOfGivenTrades.compose(findTradesStartwithPrefix);
        return chainedFunction.apply(prefix);
    }

    public static void main(String[] args) {

        //A simple function that accepts name and returns a Trade object
        Trade t = findInstrumentByName.apply("IBM");
        System.out.println(t.toString());

        //An example of chained function using andThen chain
        System.out.println(findSumOfTradesExceedingGivenAmount(300));

        //A chained function using 'compose' chain computes the reverse way than andThen
        System.out.println(findSumOfTradeInstrumentsByPrefix("A"));
    }


}
