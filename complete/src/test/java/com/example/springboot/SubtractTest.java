package com.example.springboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractTest {
    @Test
    public void testResult() {
        Subtract subtractTester = new Subtract();
//        assertEquals(2, subtractTester.subtract(4, 2));
        OperationData input = new OperationData("subtract",8,2, 0);
        OperationData output = new OperationData("subtract",8,2, 6);
        assertEquals(output,subtractTester.subtract(input));
    }
}