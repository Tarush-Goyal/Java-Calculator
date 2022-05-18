package com.example.springboot;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;

class EquationTest {
    @Test
    public void testEquation() {
        Equation equationTester = new Equation();
        OperationDataV2 input = new OperationDataV2();
        input.equation  = "a+b";
        HashMap<String,Double>variables = new HashMap<>();
        variables.put("a",1.0);
        variables.put("b",2.0);
        input.variables = variables;
        OperationDataV2 output = new OperationDataV2();
        output.equation = input.equation;
        output.variables = input.variables;
        output.result = 3.0;
        Gson gson = new Gson();
        String json = gson.toJson(input);
        assertEquals(output,equationTester.operation(json));
    }

    @Test
    public void testPrecedence() {
        Equation equationPrecedenceTester = new Equation();
        assertEquals(1,equationPrecedenceTester.precedence('+'));
        assertEquals(1,equationPrecedenceTester.precedence('-'));
        assertEquals(2,equationPrecedenceTester.precedence('*'));
        assertEquals(2,equationPrecedenceTester.precedence('/'));
        assertEquals(0,equationPrecedenceTester.precedence('a'));
    }

    @Test
    public void testOperation() {
        Equation equationOperationTester = new Equation();
        assertEquals(5.0,equationOperationTester.operation(2.0,3.0,'+'));
        assertEquals(-1.0,equationOperationTester.operation(2.0,3.0,'-'));
        assertEquals(6.0,equationOperationTester.operation(2.0,3.0,'*'));
        assertEquals(2.0,equationOperationTester.operation(6.0,3.0,'/'));
        assertEquals(0,equationOperationTester.operation(6.0,3.0,'a'));
    }

    @Test
    public void testHandleOperator(){
        Equation equationOperatorTester = new Equation();
        Stack<Double>operands=new Stack<>();
        Stack<Character>operators=new Stack<>();
        Stack<Character>operators2=new Stack<>();
        operands.push(10.0);
        operators.push('+');
        equationOperatorTester.handleOperator('+',"5",operators,operands); //both true
        equationOperatorTester.handleOperator('*',"5",operators,operands); //2nd false
        equationOperatorTester.handleOperator('+',"5",operators2,operands); //1st false
        assertNotNull(operators);
        assertNotNull(operators2);
    }

    @Test
    public void testHandleOperand(){
        Equation equationOperandTester = new Equation();
        OperationDataV2 input = new OperationDataV2();
        input.equation  = "a+b+c";
        HashMap<String,Double>variables = new HashMap<>();
        variables.put("a",1.0);
        variables.put("b",2.0);
        input.variables = variables;
        Exception exception = assertThrows(
                ResponseStatusException.class,
                () -> equationOperandTester.handleOperand('d',"23", input)
        );
        assertTrue(exception.getMessage().contains("Missing variable value"));
        assertEquals("5",equationOperandTester.handleOperand('5',"",input));
    }

    @Test
    public void testIterateEquation(){
        Equation equationIterateEquationTester = new Equation();
        OperationDataV2 input = new OperationDataV2();
        input.equation  = "a+b+c";
        HashMap<String,Double>variables = new HashMap<>();
        variables.put("a",1.0);
        variables.put("b",2.0);
        input.variables = variables;
        equationIterateEquationTester.iterateEquation("a+b",new Stack<>(),new Stack<>(),input);
        equationIterateEquationTester.iterateEquation("a-b",new Stack<>(),new Stack<>(),input);
        equationIterateEquationTester.iterateEquation("a*b",new Stack<>(),new Stack<>(),input);
        equationIterateEquationTester.iterateEquation("a/b",new Stack<>(),new Stack<>(),input);
    }
}