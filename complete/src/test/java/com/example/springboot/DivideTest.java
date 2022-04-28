package com.example.springboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    @Test
    public void testResult() {
        Divide divideTester = new Divide();
        OperationData input = new OperationData("divide",8,2, 0);
        OperationData output = new OperationData("divide",8,2, 4);
        assertEquals(output,divideTester.divide(input));
//        assertEquals(2, divideTester.divide(4, 2));
    }
}