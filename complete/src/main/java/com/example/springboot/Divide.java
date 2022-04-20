package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Divide {


    @GetMapping("/calserv/divide/{num1}/{num2}")
    public long index(@PathVariable int num1, @PathVariable int num2 ) {
        return num1/num2;
    }

}
