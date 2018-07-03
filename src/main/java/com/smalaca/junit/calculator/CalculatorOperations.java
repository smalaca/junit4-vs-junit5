package com.smalaca.junit.calculator;

public class CalculatorOperations {
    private final Calculator calculator = new Calculator();

    public CalculatorOperation getFor(Operation operation){
        switch (operation) {
            case ADDITION:
                return calculator::addition;
            case SUBSTRACTION:
                return calculator::subtraction;
            case MULTIPLICATION:
                return calculator::multiplication;
            case DIVISION:
                return calculator::division;
        }

        throw new IllegalArgumentException("Not supported operation");
    }
}
