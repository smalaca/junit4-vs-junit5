package com.smalaca.junit.parametrized;

import com.smalaca.junit.number.NumberValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class NumberIsNegativeTest {
    private final long value;

    public NumberIsNegativeTest(long value) {
        this.value = value;
    }

    @Parameters
    public static Object[] negatives() {
        return new Object[] {-13, -69, -2};
    }

    @Test
    public void shouldRecognizeNegativeNumber() {
        NumberValue number = new NumberValue(value);

        assertThat(number.isNegative()).isTrue();
    }
}
