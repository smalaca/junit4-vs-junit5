package com.smalaca.junit.calculator;

public class Calculator {
    public long addition(long first, long second) {
        return first + second;
    }

    public long subtraction(long minuend, long subtrahend) {
        return minuend - subtrahend;
    }

    public long multiplication(long firstFactor, long secondFactor) {
        return firstFactor * secondFactor;
    }

    public long division(long divident, long divider) {
        if(divider == 0L) {
            throw new IllegalArgumentException("Negative number not allowed as divider");
        }

        return divident/divider;
    }
}
