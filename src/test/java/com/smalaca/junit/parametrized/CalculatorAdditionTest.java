package com.smalaca.junit.parametrized;

import com.smalaca.junit.calculator.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CalculatorAdditionTest {
    private final Calculator calculator = new Calculator();

    private final long first;
    private final long second;
    private final long expected;

    public CalculatorAdditionTest(long first, long second, long expected) {
        this.first = first;
        this.second = second;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> parameters() {
        return asList(new Object[][] {
                {0, 0, 0},
                {1, 1, 2},
                {1, 4, 5},
                {5, 5, 10},
                {4, 9, 13}
        });
    }

    @Test
    public void shouldReturnExpectedSum() {
        long result = calculator.addition(first, second);

        assertThat(result).isEqualTo(expected);
    }
}
