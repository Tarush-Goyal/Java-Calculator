package com.example.springboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    @Test
    public void testResult() {
        Add addTester = new Add();
        assertEquals(4,addTester.add(1,3));
    }
}