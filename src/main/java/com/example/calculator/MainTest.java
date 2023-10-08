package com.example.calculator;

import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(5));
        tokenList.add(new Operand(3));
        tokenList.add(new Operand(2));
        tokenList.add(new Operator('*'));
        tokenList.add(new Operand(8));
        tokenList.add(new Operator('+'));
        tokenList.add(new Operator('-'));

        PostFixCalculator calculator = new PostFixCalculator();
        int result = calculator.evaluateExpression(tokenList);
        System.out.println("Result: " + result); // Output should be -9
    }


}
