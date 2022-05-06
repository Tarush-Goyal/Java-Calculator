package com.example.springboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {
    @Test
    public void testResult() {
        Multiply multiplyTester = new Multiply();
        OperationData input = new OperationData("multiplication",8,2, 0);
        OperationData output = new OperationData("multiplication",8,2, 16);
        assertEquals(output,multiplyTester.operation(input));
    }
}