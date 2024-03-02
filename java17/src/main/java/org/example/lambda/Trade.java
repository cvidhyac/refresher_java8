package org.example.lambda;

public record Trade(int amount, String instrument, Status status) {

    public boolean isValidInstrument() {
        return instrument != null;
    }

    public boolean isBigTrade() {
        return amount >= 10000;
    }

    public boolean isOpenTrade() {
        return status == Status.OPEN;
    }

    public boolean isValidOpenInstrument() {
        return isOpenTrade() && isValidInstrument();
    }

    @Override
    public String toString() {
        return "Trade(".concat(instrument()).concat(" ").concat(String.valueOf(amount())).concat(")");
    }

    interface Tradeable<Trade> {
        boolean check(Trade t);
    }

    public enum Status {
        OPEN,
        CLOSED
    }
}
