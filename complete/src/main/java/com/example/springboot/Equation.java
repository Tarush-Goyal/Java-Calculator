package com.example.springboot;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Stack;

@RestController
@RequestMapping(path="/calserv", produces="application/json")
public class Equation{

    public double operation(double val1, double val2, char op){
        switch (op) {
            case '+':
                return val1+val2;
            case '-':
                return val1-val2;
            case '*':
                return val1*val2;
            case '/':
                return val1/val2;
            default:
                return 0;
        }
    }

    public int precedence(char op) {
        switch (op) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public String handleOperand(Character c,String number,OperationDataV2 operationDataV2){
        if (Character.isAlphabetic(c)) {
            if (operationDataV2.variables.containsKey(c+"")) {
                number = operationDataV2.variables.get(c+"") + ""; //1
                return number;
            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing variable value: "+c);
            }
        } else {
            System.out.println("entered number += c");
            number += c; //2.33
            return number;
        }
    }

    public void handleOperator(Character c,String number, Stack<Character>operators, Stack<Double>operands){
        operands.push(Double.parseDouble(number));
        number="";
        while (operators.size() > 0 && precedence(c) <= precedence(operators.peek())) {
            double val2 = operands.pop();
            double val1 = operands.pop();
            char op = operators.pop();
            double opval = operation(val1, val2, op);
            operands.push(opval);
        }
        operators.push(c);
    }

    public void iterateEquation(String equation, Stack<Character>operators, Stack<Double>operands, OperationDataV2 operationDataV2){
        String number="";
        for(int i=0;i<equation.length();i++){
            Character c=equation.charAt(i);
            if(c == '+' || c=='-' || c=='*' || c=='/'){
                handleOperator(c,number,operators,operands);
            }else{
                number = handleOperand(c,number, operationDataV2);
            }
        }
        operands.push(Double.parseDouble(number));
    }

    public void findResult(String equation, OperationDataV2 operationDataV2){
        Stack<Double>operands=new Stack<>();
        Stack<Character>operators=new Stack<>();
        iterateEquation(equation,operators,operands, operationDataV2);
        while (operators.size() > 0) {
            double val2 = operands.pop();
            double val1 = operands.pop();
            char op = operators.pop();
            double opval = operation(val1, val2, op);
            operands.push(opval);
        }
        double result=operands.peek();
        operationDataV2.result=result;
        return;
    }

    @GetMapping("/equation")
    public OperationDataV2 operation(@RequestBody String input){
        System.out.println(input);
        Gson gson = new Gson();
        OperationDataV2 operationDataV2 = gson.fromJson(input,OperationDataV2.class);
        String equation = operationDataV2.equation;
        findResult(equation, operationDataV2);
        return operationDataV2;
    }
}


//    public operationV2(@RequestBody )
/*take equation in json payload, take variable values if any
do tdd
make interface for my input
write test case
then write enough code just to run that test case
  */