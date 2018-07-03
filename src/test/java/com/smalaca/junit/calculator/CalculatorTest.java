package com.smalaca.junit.calculator;

import com.smalaca.junit.number.NumberValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.ObjectArrayArguments.create;

class CalculatorTest {
    private static final long ANY_NUMBER = 13;
    private final Calculator calculator = new Calculator();

    @Test
    void cannotDivideByZero() {
        Executable dividingByZero = () -> calculator.division(ANY_NUMBER, 0);

        assertThrows(IllegalArgumentException.class, dividingByZero);
    }

    @ParameterizedTest
    @ValueSource(longs = {-13, -6, -100})
    void shouldRecognizeNegativeNumber(long value) {
        NumberValue number = new NumberValue(value);

        assertTrue(number.isNegative());
    }

    @ParameterizedTest
    @MethodSource(names = {"additionParameters","moreAdditionParameters"})
    @DisplayName("[{index}] addition of {0} + {1} equals {2}")
    void shouldReturnExpectedSum(long first, long second, long expected) {
        long result = calculator.addition(first, second);

        assertThat(result).isEqualTo(expected);
    }

    static Iterable<Arguments> additionParameters() {
        return asList(
                create(1L, 1L, 2L),
                create(10L, 3L, 13L),
                create(20L, 20L, 40L)
        );
    }

    static Iterable<Arguments> moreAdditionParameters() {
        return asList(
                create(1L, 2L, 3L),
                create(10L, 5L, 15L),
                create(20L, 120L, 140L)
        );
    }
}