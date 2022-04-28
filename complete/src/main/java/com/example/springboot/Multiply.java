package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Multiply {


//    @GetMapping("/calserv/multiply/{num1}/{num2}")
    @GetMapping("/calserv/multiply")
//    public long multiply (@PathVariable int num1, @PathVariable int num2 ) {
    public OperationData multiply (@RequestBody OperationData od) {
//        return num1*num2;
        od.result = od.num1 * od.num2;
        return od;
    }
}
