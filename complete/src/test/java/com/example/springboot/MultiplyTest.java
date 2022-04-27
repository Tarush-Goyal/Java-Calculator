package com.example.springboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {
    @Test
    public void testResult() {
        Multiply multiplyTester = new Multiply();
        assertEquals(8, multiplyTester.multiply(4, 2));
    }
}