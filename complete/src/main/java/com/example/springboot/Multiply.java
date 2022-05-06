package com.example.springboot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/calserv", produces="application/json")
public class Multiply implements Operation {

    @GetMapping("/multiply")
    public OperationData operation (@RequestBody OperationData operationData) {
        operationData.operation = "multiplication";
        operationData.result = operationData.num1 * operationData.num2;
        return operationData;
    }
}
