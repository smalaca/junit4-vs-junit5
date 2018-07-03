package com.smalaca.junit.parametrized;

import com.smalaca.junit.calculator.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CalculatorDivisionTest {
    private final Calculator calculator = new Calculator();

    @Parameter public long divident;
    @Parameter(1) public long divider;
    @Parameter(2) public long expected;

    @Parameters(name = "{index}: division ({0}/{1}) = {2}")
    public static Collection<Object[]> parameters() {
        return asList(new Object[][] {
                {1, 1, 1},
                {8, 4, 2},
                {5, 5, 1},
                {40, 4, 10}
        });
    }

    @Test
    public void shouldReturnExpectedResult() {
        long result = calculator.division(divident, divider);

        assertThat(result).isEqualTo(expected);
    }
}
