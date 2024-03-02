package org.example.lambda;

import java.util.ArrayList;
import java.util.List;

public class TradeUtil {
    private TradeUtil() {
    }

    public static List<Trade> createTrades() {
        List<Trade> trades = new ArrayList<>();
        trades.add(new Trade(100, "IBM", Trade.Status.OPEN));
        trades.add(new Trade(200, "RBC", Trade.Status.CLOSED));
        trades.add(new Trade(300, "GOOG", Trade.Status.OPEN));
        trades.add(new Trade(500, "TD", Trade.Status.OPEN));
        trades.add(new Trade(800, "TSLA", Trade.Status.CLOSED));
        trades.add(new Trade(700, "ATH", Trade.Status.OPEN));
        trades.add(new Trade(600, "MFG", Trade.Status.OPEN));
        trades.add(new Trade(340, "ETH", Trade.Status.CLOSED));
        trades.add(new Trade(920, "AMD", Trade.Status.OPEN));
        trades.add(new Trade(567, "AMZN", Trade.Status.OPEN));
        trades.add(new Trade(1000, "IBM", Trade.Status.OPEN));

        return trades;
    }
}
