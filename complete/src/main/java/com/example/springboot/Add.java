package com.example.springboot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/calserv", produces="application/json")
public class Add implements Operation{

    @GetMapping("/add")
    @Override
    public OperationData operation(@RequestBody OperationData operationData) {
        operationData.operation = "addition";
        operationData.result = operationData.num1 + operationData.num2;
        return operationData;
    }

}