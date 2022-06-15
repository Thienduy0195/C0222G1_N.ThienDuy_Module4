package com.calculator.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public float calculate(float firstOperand, float secondOperand, char operator) {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("invalid operation");
        }
    }
}
