package com.smalaca.junit.number;

public class NumberValue {
    private final long value;

    public NumberValue(long value) {
        this.value = value;
    }

    public boolean isNegative() {
        return value < 0;
    }
}
