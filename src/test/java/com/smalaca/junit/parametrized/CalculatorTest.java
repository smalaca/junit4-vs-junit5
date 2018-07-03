package com.smalaca.junit.parametrized;

import com.smalaca.junit.calculator.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.NamedParameters;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {
    private static final long ANY_NUMBER = 13;

    private final Calculator calculator = new Calculator();

    @Test
    @Parameters({
            "0,0,0",
            "1,1,2",
            "1,4,5",
            "5,5,10",
            "4,9,13"
    })
    public void shouldReturnExpectedSum(long first, long second, long expected) {
        long result = calculator.addition(first, second);

        assertThat(result).isEqualTo(expected);
    }

    private static Collection<Object[]> divisionParameters() {
        return asList(new Object[][] {
                {1, 1, 1},
                {8, 4, 2},
                {5, 5, 1},
                {40, 4, 10}
        });
    }

    @Test
    @Parameters(method = "divisionParameters")
    public void shouldReturnResultOfDivision(long divident, long divider, long expected) {
        long result = calculator.division(divident, divider);

        assertThat(result).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionInCaseOfZero() {
        calculator.division(ANY_NUMBER, 0);
    }

    private static Collection<Object[]> parametersForShouldReturnResultOfSubstriaction() {
        return asList(new Object[][] {
                {1, 1, 0},
                {8, 4, 4},
                {6, 5, 1},
                {40, 4, 36}
        });
    }

    @Test
    @Parameters
    public void shouldReturnResultOfSubstriaction(long minuend, long subtrahend, long expected) {
        long result = calculator.subtraction(minuend, subtrahend);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @Parameters(named = "multiplication")
    @TestCaseName("[{index}] {0} * {1} = {2}")
    public void shouldReturnResultOfMultiplication(long firstFactor, long secondFactor, long expected) {
        long result = calculator.multiplication(firstFactor, secondFactor);

        assertThat(result).isEqualTo(expected);
    }

    @NamedParameters("multiplication")
    private static Collection<Object[]> multiParams() {
        return asList(new Object[][] {
                {1, 1, 1},
                {8, 4, 32},
                {6, 5, 30},
                {40, 4, 160}
        });
    }
}
