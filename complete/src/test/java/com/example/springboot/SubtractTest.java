package com.example.springboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtractTest {
    @Test
    public void testResult() {
        Subtract subtractTester = new Subtract();
        OperationData input = new OperationData("subtraction",8,2, 0);
        OperationData output = new OperationData("subtraction",8,2, 6);
        assertEquals(output,subtractTester.operation(input));
    }
}