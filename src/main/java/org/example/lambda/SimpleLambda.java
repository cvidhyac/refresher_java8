package org.example.lambda;

import java.util.concurrent.Callable;

public class SimpleLambda {

    public void methodAcceptingCallable(Callable<String> acceptsString) {
    }

    public void methodAcceptingRunnable(Runnable runnable) {
    }


    interface Greeting {
        String sayHello(String a);
    }

    public void testGreeting(String name, Greeting greeting) {
        String result = greeting.sayHello(name);
        System.out.println(result);
    }

    public static void main(String[] args) {

        new SimpleLambda().testGreeting("Ms.Pink", s -> "Hello " + s);
        new SimpleLambda().testGreeting("Mr. George", s -> "Did you forget something " + s + "?");
        new SimpleLambda().testGreeting("", name -> name.isEmpty() ? "No name provided" : "Hello again, " + name);

        Runnable runnableLambda = () -> System.out.println("Hello world");
        Callable callableLambda = () -> new String("Hello I am a String");
        new SimpleLambda().methodAcceptingCallable(callableLambda);
        new SimpleLambda().methodAcceptingRunnable(() -> System.out.print("Hello Lambda!"));

        Trade.Tradeable<Trade> bigTradeLambda = t -> t.isBigTrade();
        Trade.Tradeable<Trade> isValidInstrumentLambda = t -> t.isValidInstrument();
        Trade.Tradeable<Trade> isInstrumentNameIBM = t -> t.instrument().equals("IBM");
    }
}
