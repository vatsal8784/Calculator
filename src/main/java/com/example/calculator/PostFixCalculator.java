package com.example.calculator;

import com.example.calculator.Operand;
import com.example.calculator.Operator;
import com.example.calculator.Token;

import java.util.ArrayList;
import java.util.Stack;

public class PostFixCalculator {
    public int evaluateExpression(ArrayList<Token> tokenList) {
        Stack<Integer> stack = new Stack<>();

        for (Token token : tokenList) {
            if (token instanceof Operand) {
                stack.push(((Operand) token).getValue());
            } else if (token instanceof Operator) {
                char op = ((Operator) token).getOperator();
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, op);
                stack.push(result);
            }
        }

        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalArgumentException("Invalid expression: Empty stack");
        }
    }

    private int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
