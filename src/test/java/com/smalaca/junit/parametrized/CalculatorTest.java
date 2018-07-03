package com.smalaca.junit.parametrized;

import com.smalaca.junit.calculator.Calculator;
import org.junit.Test;

public class CalculatorTest {
    private static final long ANY_NUMBER = 13;

    private final Calculator calculator = new Calculator();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionInCaseOfZero() {
        calculator.division(ANY_NUMBER, 0);
    }
}
