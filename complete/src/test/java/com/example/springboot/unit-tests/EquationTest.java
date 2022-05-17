package com.example.springboot;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class EquationTest {
    @Test
    public void testResult() throws JSONException {
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
}