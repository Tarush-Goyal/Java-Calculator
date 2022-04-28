package com.example.springboot;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path="/calserv", consumes = MediaType.ALL_VALUE, produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
@RequestMapping(path="/calserv", produces="application/json")
//@CrossOrigin(origins="*")
public class Add {

    //    @GetMapping(value = "/add/{num1}/{num2}", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/add")
    public OperationData add(@RequestBody OperationData od) {
        od.result = od.num1 + od.num2;
        return od;
    }

}