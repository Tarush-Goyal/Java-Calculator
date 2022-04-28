package com.example.springboot;

import lombok.Data;

@Data
public class OperationData {
    String operation;
    double num1;
    double num2;
    double result;

    OperationData(String operation, double num1, double num2, double result){
        this.operation=operation;
        this.num1=num1;
        this.num2=num2;
        this.result=result;
    }
}