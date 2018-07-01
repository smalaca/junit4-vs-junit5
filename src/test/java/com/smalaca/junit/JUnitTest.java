package com.smalaca.junit;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JUnitTest {
    @Test
    public void shouldRecognizeJUnitAwesomeness() {
        assertTrue(new JUnit().isAwesome());
    }
}
