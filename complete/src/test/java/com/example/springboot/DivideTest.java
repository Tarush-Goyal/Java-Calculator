package com.example.springboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    @Test
    public void testResult() {
        Divide divideTester = new Divide();
        assertEquals(2, divideTester.divide(4, 2));
    }
}