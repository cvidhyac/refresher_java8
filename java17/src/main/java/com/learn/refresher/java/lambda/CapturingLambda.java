package com.learn.refresher.java.lambda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CapturingLambda {
    public static void main(String[] args) {

        Trade ibmTrade = new Trade(2000, "IBM", Trade.Status.OPEN);
        Trade microsoftTrade = new Trade(30000, "MS", Trade.Status.CLOSED);
        log.info("Is IBM a big trade?" + new CapturingLambda().isOpenAndBigTrade(1000, Trade.Status.CLOSED, ibmTrade));
        log.info("Is Microsoft tradle Open?".concat(String.valueOf(microsoftTrade.isOpenTrade())));
        log.info("Is Trade Valid?".concat(String.valueOf(isValidTrade(microsoftTrade))));
    }

    public static boolean isValidTrade(Trade trade) {
        Trade.Tradeable<Trade> simpleLambda = Trade::isValidOpenInstrument;
        return simpleLambda.check(trade);
    }


    public boolean isOpenAndBigTrade(int tradeAmount, Trade.Status currentStatus, Trade trade) {
        Trade.Tradeable<Trade> openAndBigTradeLambda = t -> t.amount() > tradeAmount && currentStatus == Trade.Status.OPEN;
        return openAndBigTradeLambda.check(trade);
    }

}
