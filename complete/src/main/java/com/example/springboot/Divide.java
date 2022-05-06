package com.example.springboot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/calserv", produces="application/json")
public class Divide implements Operation{

@GetMapping("/divide")
    public OperationData operation (@RequestBody OperationData operationData) {
      operationData.operation = "division";
      operationData.result = operationData.num1/operationData.num2;
      return operationData;
    }
}
