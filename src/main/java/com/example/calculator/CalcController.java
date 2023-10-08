package com.example.calculator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CalcController {

    @PostMapping("/calculate")
    public int calculateExpression(@RequestBody ArrayList<Token> tokenList) {
        PostFixCalculator calculator = new PostFixCalculator();
        return calculator.evaluateExpression(tokenList);
    }
}

