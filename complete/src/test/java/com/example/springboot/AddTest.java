package com.example.springboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    @Test
    public void testResult() {
        Add addTester = new Add();
        OperationData input = new OperationData("add",2,3, 0);
        OperationData output = new OperationData("add",2,3, 5);
        assertEquals(output,addTester.add(input));
    }
}