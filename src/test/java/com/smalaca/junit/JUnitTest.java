package com.smalaca.junit;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitTest {
    @Test
    public void shouldRecognizeJUnitAwesomeness() {
        assertTrue(new JUnit().isAwesome());
    }
}
