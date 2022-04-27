package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Add {


    @GetMapping("/calserv/add/{num1}/{num2}")
    public long add (@PathVariable int num1, @PathVariable int num2 ) {
        return num1+num2;
    }

}
