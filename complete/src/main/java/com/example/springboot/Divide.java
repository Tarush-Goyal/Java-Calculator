package com.example.springboot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/calserv", produces="application/json")
public class Divide {

@GetMapping("/divide")
    public OperationData divide (@RequestBody OperationData od) {
      od.result = od.num1/od.num2;
      return od;
    }
}
