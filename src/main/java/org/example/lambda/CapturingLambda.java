package org.example.lambda;

public class CapturingLambda {

    public static void main(String[] args) {

        Trade ibmTrade = new Trade(2000, "IBM", Trade.Status.OPEN);
        Trade microsoftTrade = new Trade(30000, "MS", Trade.Status.CLOSED);
        System.out.println("Is IBM a big trade?" + new CapturingLambda().isOpenAndBigTrade(1000, Trade.Status.CLOSED, ibmTrade));
    }

    public boolean isValidTrade(Trade trade) {
        Trade.Tradeable<Trade> simpleLambda = t -> t.isValidOpenInstrument();
        return simpleLambda.check(trade);
    }


    public boolean isOpenAndBigTrade(int tradeAmount, Trade.Status currentStatus, Trade trade) {
        Trade.Tradeable<Trade> openAndBigTradeLambda = t -> t.amount() > tradeAmount && currentStatus == Trade.Status.OPEN;
        return openAndBigTradeLambda.check(trade);
    }

}
