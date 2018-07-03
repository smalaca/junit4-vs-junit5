package com.smalaca.junit.calculator;

import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.stream.Stream;

import static com.smalaca.junit.calculator.Operation.ADDITION;
import static com.smalaca.junit.calculator.Operation.MULTIPLICATION;
import static com.smalaca.junit.calculator.Operation.SUBSTRACTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.ObjectArrayArguments.create;

class CalculatorOperationsTest {
    private static final long ANY_FIRST = 1;
    private static final long ANY_SECOND = 2;
    private static final long ZERO = 0;

    private final CalculatorOperations calculatorOperations = new CalculatorOperations();

    @ParameterizedTest
    @EnumSource(Operation.class)
    void shouldSupportAllOperations(Operation operation) {
        long result = calculatorOperations.getFor(operation).execute(ANY_FIRST, ANY_SECOND);

        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @EnumSource(value = Operation.class, names = {"ADDITION", "SUBSTRACTION", "MULTIPLICATION"})
    void shouldSupportZeroAsSecondParam(Operation operation) {
        long result = calculatorOperations.getFor(operation).execute(ANY_FIRST, ZERO);

        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"1,1,2","2,2,4","3,4,7"})
    void shouldReturnExpectedSum(long first, long second, long expected) {
        long result = calculatorOperations.getFor(ADDITION).execute(first, second);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/input1.csv", "/input2.csv"})
    void shouldReturnExpectedResultForGivenOperation(Operation operation, long first, long second, long expected) {
        long result = calculatorOperations.getFor(operation).execute(first, second);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSources({
            @ArgumentsSource(CalculatorOperationsParamsProvider.class),
            @ArgumentsSource(OperationsParamsProvider.class)
    })
    void shouldReturnExpectedResultForOperation(Operation operation, long first, long second, long expected) {
        long result = calculatorOperations.getFor(operation).execute(first, second);

        assertThat(result).isEqualTo(expected);
    }

    static class CalculatorOperationsParamsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> arguments(ContainerExtensionContext containerExtensionContext) {
            return Stream.of(
                    create(ADDITION, 1L, 2L, 3L),
                    create(SUBSTRACTION, 10L, 5L, 5L),
                    create(MULTIPLICATION, 20L, 20L, 400L)
            );
        }
    }

    static class OperationsParamsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> arguments(ContainerExtensionContext containerExtensionContext) {
            return Stream.of(
                    create(ADDITION, 1L, 2L, 3L),
                    create(SUBSTRACTION, 10L, 5L, 5L),
                    create(MULTIPLICATION, 20L, 20L, 400L)
            );
        }
    }
}