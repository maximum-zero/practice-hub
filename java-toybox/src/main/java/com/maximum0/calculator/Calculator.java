package com.maximum0.calculator;

public class Calculator {
    public static int calculate(int operand1, String operator, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 < 1) {
                    throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
                }
                return operand1 / operand2;
            default: throw new ArithmeticException("올바른 사칙 연산이 아닙니다.");
        }
    }
}
