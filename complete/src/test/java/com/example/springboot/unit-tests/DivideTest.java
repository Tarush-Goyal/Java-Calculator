package com.example.springboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivideTest {
    @Test
    public void testResult() {
        Divide divideTester = new Divide();
        OperationData input = new OperationData("division",8,2, 0);
        OperationData output = new OperationData("division",8,2, 4);
        assertEquals(output,divideTester.operation(input));
    }
}