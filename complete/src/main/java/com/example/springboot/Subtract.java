package com.example.springboot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/calserv", produces="application/json")
public class Subtract implements Operation{

    @GetMapping("/subtract")
    public OperationData operation (@RequestBody OperationData operationData) {
        operationData.operation = "subtraction";
        operationData.result = operationData.num1 - operationData.num2;
        return operationData;
    }
    //remove operation from input keep in o/p
    //add api endpoint test case
    // currently have unit test code coverage
    //generate integrated code coverage on deployed app
    //big decimal
    //for divide, divide by 0 not possible
}
