package com.example.springboot;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class OperationDataV2 {
    String equation;
    HashMap<String,Double>variables;
    double result;
}