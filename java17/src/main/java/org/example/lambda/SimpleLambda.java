package org.example.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class SimpleLambda {

    public void methodAcceptingCallable(Callable<String> acceptsString) throws Exception {
        log.info("A method accepting callable");
        acceptsString.call();
    }

    public void methodAcceptingRunnable(Runnable runnable) {
        log.info("A Method accepting runnable");
        runnable.run();
    }


    interface Greeting {
        String sayHello(String a);
    }

    public void testGreeting(String name, Greeting greeting) {
        String result = greeting.sayHello(name);
        log.info(result);
    }

    public static void main(String[] args) throws Exception {

        new SimpleLambda().testGreeting("Ms.Pink", s -> "Hello " + s);
        new SimpleLambda().testGreeting("Mr. George", s -> "Did you forget something " + s + "?");
        new SimpleLambda().testGreeting("", name -> name.isEmpty() ? "No name provided" : "Hello again, " + name);

        Runnable runnableLambda = () -> log.info("Hello world");
        runnableLambda.run();
        Callable<String> callableLambda = () -> "Hello I am a String";
        new SimpleLambda().methodAcceptingCallable(callableLambda);
        new SimpleLambda().methodAcceptingRunnable(() -> log.info("Hello Lambda!"));

        Trade.Tradeable<Trade> bigTradeLambda = Trade::isBigTrade;
        Trade.Tradeable<Trade> isValidInstrumentLambda = Trade::isValidInstrument;
        Trade.Tradeable<Trade> isInstrumentNameIBM = t -> t.instrument().equals("IBM");

        Trade aRandomTrade = TradeUtil.createTrades().get(0);
        log.info("Is BigTrade: {}", bigTradeLambda.check(aRandomTrade));
        log.info("IsValidInstrument: {}", isValidInstrumentLambda.check(aRandomTrade));
        log.info("CheckInstrumentName: {}", isInstrumentNameIBM.check(aRandomTrade));

    }
}
