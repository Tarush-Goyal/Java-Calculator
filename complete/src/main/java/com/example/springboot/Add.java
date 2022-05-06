package com.example.springboot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/calserv", produces="application/json")
public class Add implements Operation{

    @GetMapping("/add")
    @Override
    public OperationData operation(@RequestBody OperationData operationData) {
        operationData.operation = "addition";
//        operationData.num1 = 4;
//        operationData.num2 = 2;
//        ps -ef | grep java | awk '{print $2}' | xargs kill -9
        operationData.result = operationData.num1 + operationData.num2;
        return operationData;
    }

}