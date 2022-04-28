package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Divide {


//    @GetMapping("/calserv/divide/{num1}/{num2}")
@GetMapping("/calserv/divide")
//    public long divide (@PathVariable int num1, @PathVariable int num2 ) {
    public OperationData divide (@RequestBody OperationData od) {
//        return num1/num2;
      od.result = od.num1/od.num2;
      return od;
    }

    //add java docs
    //divide by 0 test case in divide
    //create interface
    //decimal value for divide
    //big decimal/double for result and maybe for path variables as well?
    //make test case for rest endpoint with num1 and num2 (Restasured based unit testing)
    //write java docs for the test cases
    //write test case if only 1 num passed in url instead of 2
    //get json input and return json

    //i have 3 diff approaches to our problem so i wanted to discuss the soln before implementing any 1
    //instead of different classes each for add, subtract etc. can i have a single class called operations?
    // in url ill also change from add, subtract to /calserv/{operation}/{num1}/{num2}
    //then only 1 method with 4 if statements as per operation will be required and a default if none of the above
    //we will only require 1 method with 4 lines of code as compared to 4 classes and 1 interface
    //   OR
    //in that single class called operations,4 methods as per url get req
    //   OR (interface approach)
    /*
    interface method will be
    public long operation(@PathVariable int num1, @PathVariable int num2);

    so for eg in add class

    public class Add implements Operations{

    @GetMapping("/add/{num1}/{num2}")
    @Override
    public long operation (@PathVariable int num1, @PathVariable int num2 ) {
        return num1+num2;
    }

}
then i can add some documentation for operation method in each class
     */
}
